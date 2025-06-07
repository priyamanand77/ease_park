package com.ease.park.exception;


import org.springframework.http.HttpStatus;

public class EaseParkException extends RuntimeException {

    private HttpStatus httpStatus;

    public EaseParkException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
