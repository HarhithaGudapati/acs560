package com.acs560.Sport_analyzer.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TeamExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException() {
        return ResponseEntity.badRequest().body("No match found");
    }
}