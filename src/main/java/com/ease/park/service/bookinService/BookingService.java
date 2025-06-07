package com.ease.park.service.bookinService;

import com.ease.park.dto.slotRequest.BookSlotRequestDto;

public interface BookingService {
    BookSlotRequestDto getBooking(BookSlotRequestDto bookSlotRequestDto);
}
