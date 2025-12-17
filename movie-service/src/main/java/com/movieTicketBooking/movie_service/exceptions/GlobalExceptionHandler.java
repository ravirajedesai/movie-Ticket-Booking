package com.movieTicketBooking.movie_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<String> MovieNotFound(MovieNotFound ex){
        return ResponseEntity.ok(ex.getMessage());
    }
}
