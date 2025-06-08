package com.ease.park.repo.parkingSpace;

import com.ease.park.entity.parkingSpace.ParkingSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceRepo extends JpaRepository<ParkingSpaceEntity, Long> {

    Optional<ParkingSpaceEntity> findByParkingSpaceId(String parkingSpaceId);

    List<ParkingSpaceEntity> findAllByActiveIsTrueAndParkingType( String parkingType);

}
