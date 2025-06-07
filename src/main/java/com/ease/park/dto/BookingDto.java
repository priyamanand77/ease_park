package com.ease.park.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {
    private Long id;
    private String cardId;
    private String name;
    private String ph;
    private String parkingSpaceId;
    private Timestamp inTTime;
    private Timestamp outTTime;
    private Boolean status;
}