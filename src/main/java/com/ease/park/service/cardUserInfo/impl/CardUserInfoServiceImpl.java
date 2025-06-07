package com.ease.park.service.cardUserInfo.impl;

import com.ease.park.dto.cardUserInfo.CardUserInfoDto;
import com.ease.park.entity.cardInfoUser.CardInfoUserEntity;
import com.ease.park.repo.cardUserInfo.CardUserInfoRepo;
import com.ease.park.service.cardUserInfo.CardUserInfoService;
import com.ease.park.utility.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardUserInfoServiceImpl implements CardUserInfoService {

    private final CardUserInfoRepo cardUserInfoRepo;

    @Override
    public List<CardUserInfoDto> saveCardUserInfo(List<CardUserInfoDto> cardUserInfoDto) {
        log.info("inside saveCardUserInfo -> data : {} ", cardUserInfoDto);
        List<CardInfoUserEntity> cardInfoUserEntities = cardUserInfoRepo.saveAll(cardUserInfoDto.stream().map(x -> Mapper.toEntity(x, CardInfoUserEntity.class)).toList());
        return cardInfoUserEntities.stream().map(x -> Mapper.toDto(x, CardUserInfoDto.class)).toList();
    }
}
