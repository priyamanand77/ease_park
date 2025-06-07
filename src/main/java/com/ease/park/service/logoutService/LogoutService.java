package com.ease.park.service.logoutService;

import com.ease.park.dto.booking.BookingDto;
import com.ease.park.dto.slotRequest.BookSlotRequestDto;

public interface LogoutService {
    BookingDto logOutUser(BookSlotRequestDto bookSlotRequestDto);
}
