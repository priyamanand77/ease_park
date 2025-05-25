package com.ease.park.repo.cardUserInfo;

import com.ease.park.entity.cardInfoUser.CardInfoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardUserInfoRepo extends JpaRepository<CardInfoUserEntity, Long> {
}
