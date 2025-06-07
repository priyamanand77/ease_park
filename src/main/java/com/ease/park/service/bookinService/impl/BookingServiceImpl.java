package com.ease.park.service.bookinService.impl;

import com.ease.park.dto.cardUserInfo.CardUserInfoDto;
import com.ease.park.dto.parkingspace.ParkingSpacesDto;
import com.ease.park.dto.slotRequest.BookSlotRequestDto;
import com.ease.park.entity.bookingStatus.BookingEntity;
import com.ease.park.entity.cardInfoUser.CardInfoUserEntity;
import com.ease.park.entity.parkingSpace.ParkingSpaceEntity;
import com.ease.park.exception.EaseParkException;
import com.ease.park.repo.booking.BookingRepo;
import com.ease.park.repo.cardUserInfo.CardUserInfoRepo;
import com.ease.park.repo.parkingSpace.ParkingSpaceRepo;
import com.ease.park.service.bookinService.BookingService;
import com.ease.park.utility.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final CardUserInfoRepo cardUserInfoRepo;
    private final ParkingSpaceRepo parkingSpaceRepo;
    private final BookingRepo bookingRepo;

    @Override
    public BookSlotRequestDto getBooking(BookSlotRequestDto bookSlotRequestDto) {
        try {
            Optional<BookingEntity> bookingAlreadyExists = bookingRepo.findByCardIdOrPhAndStatusIsTrue(bookSlotRequestDto.getCardUserInfoDto().getCardId(), bookSlotRequestDto.getCardUserInfoDto().getPh());
            if (bookingAlreadyExists.isPresent())
                throw new EaseParkException("booking already exists", HttpStatus.BAD_REQUEST);

            log.info("inside getBooking -> data : {} ", bookSlotRequestDto);
            ParkingSpaceEntity parkingSpace = parkingSpaceRepo.findAll().parallelStream()
                    .filter(ParkingSpaceEntity::getIsActive)
                    .findAny().orElseThrow(() -> new EaseParkException("no parking space available", HttpStatus.INTERNAL_SERVER_ERROR));

            CardInfoUserEntity byCardIdOrPh = cardUserInfoRepo.findByCardIdOrPh(bookSlotRequestDto.getCardUserInfoDto().getCardId(), bookSlotRequestDto.getCardUserInfoDto().getPh())
                    .orElseThrow(() -> new EaseParkException("card not found", HttpStatus.BAD_REQUEST));

            parkingSpace.setIsActive(false);
            parkingSpaceRepo.save(parkingSpace);
            BookSlotRequestDto slotRequestDto = BookSlotRequestDto.builder()
                    .cardUserInfoDto(Mapper.toDto(byCardIdOrPh, CardUserInfoDto.class))
                    .parkingSpacesDto(Mapper.toDto(parkingSpace, ParkingSpacesDto.class))
                    .startTime(bookSlotRequestDto.getStartTime())
                    .endTime(Optional.ofNullable(bookSlotRequestDto.getEndTime()).orElse(new Timestamp(bookSlotRequestDto.getStartTime().getTime() + 28800000)))
                    .build();
            BookingEntity bookingEntity = BookingEntity.builder()
                    .cardId(slotRequestDto.getCardUserInfoDto().getCardId())
                    .ph(slotRequestDto.getCardUserInfoDto().getPh())
                    .name(slotRequestDto.getCardUserInfoDto().getName())
                    .inTTime(slotRequestDto.getStartTime())
                    .outTTime(slotRequestDto.getEndTime())
                    .parkingSpaceId(slotRequestDto.getParkingSpacesDto().getParkingSpaceId())
                    .build();

            CompletableFuture.runAsync(() -> bookingRepo.save(bookingEntity));
            return slotRequestDto;
        } catch (EaseParkException e) {
            log.error(" error :", e);
            throw e;
        } catch (Exception e) {
            log.error(" error :", e);
            throw new EaseParkException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
