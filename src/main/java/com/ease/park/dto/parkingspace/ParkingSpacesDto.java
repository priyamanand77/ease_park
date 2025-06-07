package com.ease.park.dto.parkingspace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpacesDto {
    private Long id;
    private String parkingSpaceId;
    private String directionToReach;
    private String floor;
    private Boolean isActive;
}
