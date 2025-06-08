package com.ease.park.service.logoutService.impl;

import com.ease.park.dto.booking.BookingDto;
import com.ease.park.dto.slotRequest.BookSlotRequestDto;
import com.ease.park.entity.bookingStatus.BookingEntity;
import com.ease.park.entity.parkingSpace.ParkingSpaceEntity;
import com.ease.park.exception.EaseParkException;
import com.ease.park.repo.booking.BookingRepo;
import com.ease.park.repo.cardUserInfo.CardUserInfoRepo;
import com.ease.park.repo.parkingSpace.ParkingSpaceRepo;
import com.ease.park.service.logoutService.LogoutService;
import com.ease.park.utility.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final CardUserInfoRepo cardUserInfoRepo;
    private final ParkingSpaceRepo parkingSpaceRepo;
    private final BookingRepo bookingRepo;


    @Override
    public BookingDto logOutUser(BookSlotRequestDto bookSlotRequestDto) {
        log.info("inside logOutUser : {} ", bookSlotRequestDto);

        BookingEntity bookingEntity = bookingRepo.findByStatusIsTrueAndCardIdOrPh(bookSlotRequestDto.getCardUserInfoDto().getCardId(), bookSlotRequestDto.getCardUserInfoDto().getPh()).orElseThrow(() -> new EaseParkException("booking not found", HttpStatus.BAD_REQUEST));
        ParkingSpaceEntity parkingSpaceEntity = parkingSpaceRepo.findByParkingSpaceId(bookingEntity.getParkingSpaceId()).orElseThrow(() -> new EaseParkException("parking space not found", HttpStatus.BAD_REQUEST));
        bookingEntity.setStatus(false);
        parkingSpaceEntity.setActive(true);
        CompletableFuture.runAsync(() -> {
            BookingEntity save = bookingRepo.save(bookingEntity);
            log.info("inside logOutUser -> saved bookingEntity : {} ", save);
        });
        CompletableFuture.runAsync(() -> {
            ParkingSpaceEntity save = parkingSpaceRepo.save(parkingSpaceEntity);
            log.info("inside logOutUser -> saved parkingSpaceEntity : {} ", save);
        });

        return Mapper.toDto(bookingEntity, BookingDto.class);
    }
}
