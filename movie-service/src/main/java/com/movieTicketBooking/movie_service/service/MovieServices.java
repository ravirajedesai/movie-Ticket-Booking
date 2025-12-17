package com.movieTicketBooking.movie_service.service;

import com.movieTicketBooking.movie_service.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieServices {
    Page<Movie> getAllMovies(int pageNo,int pageSize,String sortBy);
    Movie getMovieById(Long id);
    void deleteMovieById(Long id);
    Movie addMovie(Movie movie);

    Movie getMovieByName(String name);
    void reduceSeats(String name,Long id);
}
