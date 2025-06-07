package com.ease.park.controller.pakingSpace;

import com.ease.park.dto.parkingspace.ParkingSpacesDto;
import com.ease.park.dto.response.ParkingResponse;
import com.ease.park.service.parkingSpace.AddParkingSpaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class AddParkingSpaceController {


    private final AddParkingSpaceService addParkingSpaceService;

    @PostMapping("/add-space")
    public ResponseEntity<ParkingResponse> addParkingSpace(@RequestBody List<ParkingSpacesDto> parkingSpacesDto) {
        log.info("inside addParkingSpace : {} ", parkingSpacesDto);
        List<ParkingSpacesDto> response = addParkingSpaceService.saveParkingSpace(parkingSpacesDto);
        ParkingResponse parkingResponse = ParkingResponse.builder().code(HttpStatus.OK.value()).message("success").data(response).build();
        return ResponseEntity.ok(parkingResponse);
    }

}
