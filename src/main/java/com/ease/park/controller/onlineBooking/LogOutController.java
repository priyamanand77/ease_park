package com.ease.park.controller.onlineBooking;

import com.ease.park.dto.booking.BookingDto;
import com.ease.park.dto.response.ParkingResponse;
import com.ease.park.dto.slotRequest.BookSlotRequestDto;
import com.ease.park.service.logoutService.LogoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/logout")
public class LogOutController {

    private final LogoutService logoutService;

    @PostMapping("/user")
    public ResponseEntity<ParkingResponse> logOutUser(@RequestBody BookSlotRequestDto bookSlotRequestDto) {
        log.info("inside logOutUser : {} ", bookSlotRequestDto);
        BookingDto bookSlotResponse = logoutService.logOutUser(bookSlotRequestDto);
        return ResponseEntity.ok(ParkingResponse.builder().code(200).message("success").data(bookSlotResponse).build());
    }

}
