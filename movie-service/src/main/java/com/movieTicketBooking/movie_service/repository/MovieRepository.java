package com.movieTicketBooking.movie_service.repository;

import com.movieTicketBooking.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie>findByMovieName(String name);
}
