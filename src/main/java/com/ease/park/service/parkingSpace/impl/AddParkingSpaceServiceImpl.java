package com.ease.park.service.parkingSpace.impl;

import com.ease.park.dto.parkingspace.ParkingSpacesDto;
import com.ease.park.entity.parkingSpace.ParkingSpaceEntity;
import com.ease.park.repo.parkingSpace.ParkingSpaceRepo;
import com.ease.park.service.parkingSpace.AddParkingSpaceService;
import com.ease.park.utility.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddParkingSpaceServiceImpl implements AddParkingSpaceService {

    private final ParkingSpaceRepo parkingSpaceRepo;

    @Override

    public List<ParkingSpacesDto> saveParkingSpace(List<ParkingSpacesDto> parkingSpacesDto) {
        log.info("inside saveParkingSpace -> dto -> data : {} ", parkingSpacesDto);
        List<ParkingSpaceEntity> parkingSpaceEntities = parkingSpaceRepo.saveAll(parkingSpacesDto.parallelStream().map(x -> Mapper.toDto(x, ParkingSpaceEntity.class)).toList());
        log.info("inside savedParkingSpace -> Entity -> data : {} ", parkingSpaceEntities);
        return parkingSpaceEntities.parallelStream().map(x -> Mapper.toDto(x, ParkingSpacesDto.class)).toList();
    }
}
