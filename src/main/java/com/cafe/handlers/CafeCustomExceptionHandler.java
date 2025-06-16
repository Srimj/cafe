package com.cafe.handlers;

import com.cafe.exception.CafeCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CafeCustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CafeCustomException.class)
    public Map<String, Object> customExceptionHandler(CafeCustomException ex){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("code", ex.getCode());
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }
}
