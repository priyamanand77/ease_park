package com.ease.park.dto.slotRequest;


import com.ease.park.dto.cardUserInfo.CardUserInfoDto;
import com.ease.park.dto.parkingspace.ParkingSpacesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookSlotRequestDto {

    private CardUserInfoDto cardUserInfoDto;
    private Timestamp startTime;
    private Timestamp endTime; // by default 8 hours
    private ParkingSpacesDto parkingSpacesDto;
}
