package com.ease.park.repo.cardUserInfo;

import com.ease.park.entity.cardInfoUser.CardInfoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardUserInfoRepo extends JpaRepository<CardInfoUserEntity, Long> {
    Optional<CardInfoUserEntity> findByCardIdOrPh(String cardId, String ph);

}
