package com.ease.park.controller.cardUserInfo;

import com.ease.park.dto.cardUserInfo.CardUserInfoDto;
import com.ease.park.dto.response.ParkingResponse;
import com.ease.park.service.cardUserInfo.CardUserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cardUserInfo")
@Slf4j
public class CardUserInfoController {

    private final CardUserInfoService cardUserInfoService;

    @PostMapping("/save")
    public ResponseEntity<ParkingResponse> saveCardUserInfo(@RequestBody List<CardUserInfoDto> cardUserInfoDto) {
        log.info("inside saveCardUserInfo -> data : {} ", cardUserInfoDto);
        List<CardUserInfoDto> savedCardUserInfo = cardUserInfoService.saveCardUserInfo(cardUserInfoDto);
        ParkingResponse parkingResponse = ParkingResponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.name()).data(savedCardUserInfo).build();
        return ResponseEntity.ok(parkingResponse);
    }
}
