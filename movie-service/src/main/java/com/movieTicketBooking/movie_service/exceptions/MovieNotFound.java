package com.movieTicketBooking.movie_service.exceptions;


public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String message) {
        super(message);
    }
}
