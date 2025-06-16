package com.cafe.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CafeCustomException extends RuntimeException{
    private final int code;
    String message;

    public CafeCustomException(int code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
