package com.ease.park.service.parkingSpace;

import com.ease.park.dto.parkingspace.ParkingSpacesDto;

import java.util.List;

public interface AddParkingSpaceService {
    List<ParkingSpacesDto> saveParkingSpace(List<ParkingSpacesDto> parkingSpacesDto);
}
