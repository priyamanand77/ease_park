package com.ease.park.repo.booking;

import com.ease.park.entity.bookingStatus.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {
    Optional<BookingEntity> findByStatusIsTrueAndCardIdOrPh(String cardId, String ph);
}
