package com.ease.park.controller.onlineBooking;

import com.ease.park.dto.response.ParkingResponse;
import com.ease.park.dto.slotRequest.BookSlotRequestDto;
import com.ease.park.service.bookinService.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/slot")
    public ResponseEntity<ParkingResponse> bookSlotForParking(@RequestBody BookSlotRequestDto bookSlotRequestDto) {
        log.info("inside bookSlotForParking -> data :{}", bookSlotRequestDto);
        BookSlotRequestDto bookSlot = bookingService.getBooking(bookSlotRequestDto);
        ParkingResponse parkingResponse = ParkingResponse.builder().code(200).data(bookSlot).message("success").build();
        return ResponseEntity.ok(parkingResponse);
    }


}
