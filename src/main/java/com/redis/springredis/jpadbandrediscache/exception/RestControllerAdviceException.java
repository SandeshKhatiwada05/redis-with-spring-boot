package com.redis.springredis.jpadbandrediscache.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestControllerAdviceException {

    @ExceptionHandler(NoValueException.class)
    public ResponseEntity<?> noValue(NoValueException ex) {
        log.error("No value found");
        return new ResponseEntity<>(ex, HttpStatus.NO_CONTENT);
    }
}
