package com.movieTicketBooking.movie_service.service;

import com.movieTicketBooking.movie_service.entity.Movie;
import com.movieTicketBooking.movie_service.exceptions.MovieNotFound;
import com.movieTicketBooking.movie_service.repository.MovieRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieServices{

    @Autowired
    MovieRepository repository;

    @Override
    public Page<Movie> getAllMovies(int pageNo,
                                    int pageSize,
                                    String sortBy) {
        Pageable pageable= PageRequest.of(
                pageNo,
                pageSize,
                Sort.by(sortBy).ascending());

        return repository.findAll(pageable);
    }
    @Override
    public Movie getMovieById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new MovieNotFound("Movie Not Found.."));
    }
    @Override
    public void deleteMovieById(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Movie addMovie(Movie movie) {
        Movie add=repository.save(movie);
        return add;
    }

    @Override
    public Movie getMovieByName(String name) {
        return repository.findByMovieName(name)
                .orElseThrow(()->
                        new MovieNotFound("Movie Not Found with Name: "+name));
    }

    @Override
    public void reduceSeats(String name, Long seat) {
        Movie movie=repository.findByMovieName(name)
                .orElseThrow(()->
                        new MovieNotFound("Movie not Found.."+name));
        movie.setSeats(movie.getSeats()-seat);
        repository.save(movie);
    }
}
