package com.ease.park.dto.cardUserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardUserInfoDto {

    private Long id;
    private String cardId;
    private String name;
    private String ph;
}
