package com.ease.park.exception;

import com.ease.park.dto.response.ParkingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericException {


    @ExceptionHandler(EaseParkException.class)
    public ResponseEntity<ParkingResponse> handleEaseParkException(EaseParkException e) {
        return
                ResponseEntity.status(e.getHttpStatus()).body(
                        ParkingResponse.builder().code(e.getHttpStatus().value()).message(e.getHttpStatus().getReasonPhrase()).data(e.getMessage()).build());
    }

}
