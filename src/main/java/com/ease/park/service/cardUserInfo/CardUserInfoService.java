package com.ease.park.service.cardUserInfo;

import com.ease.park.dto.cardUserInfo.CardUserInfoDto;

import java.util.List;

public interface CardUserInfoService {
    List<CardUserInfoDto> saveCardUserInfo(List<CardUserInfoDto> cardUserInfoDto);
}
