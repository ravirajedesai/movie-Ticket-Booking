package com.movieTicketBooking.movie_service.controller;

import com.movieTicketBooking.movie_service.dto.Movieresponse;
import com.movieTicketBooking.movie_service.entity.Movie;
import com.movieTicketBooking.movie_service.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServices services;

    @GetMapping
    ResponseEntity<Page<Movie>>
    getAllMovies(@RequestParam(defaultValue = "1") int pageNo,
                 @RequestParam(defaultValue = "4") int pageSize,
                 @RequestParam(defaultValue = "movieName") String sortBy){

        return ResponseEntity.status(HttpStatus.OK)
                .body(services.getAllMovies(pageNo,pageSize,sortBy));
    }
    @GetMapping("/{id}")
    ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie byId=services.getMovieById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovieById(@PathVariable Long id){
        services.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie add=services.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(add);
    }
    @GetMapping(value = "/name/{name}",produces = "application/json")
    public ResponseEntity<Movieresponse>
                        getMovieByName(@PathVariable String name) {

        Movie movie = services.getMovieByName(name); // fetch Movie entity

        Movieresponse response = new Movieresponse();
        response.setMovieName(movie.getMovieName());
        response.setRate(movie.getRate());
        // set other fields if needed
        return ResponseEntity.ok(response); // ✅ Returns JSON
    }
    @PutMapping("/name/{name}/seat")
    String reduceMovieSeats(@PathVariable(name = "name")String name,
                            @RequestParam(name = "seat")Long seat){
        services.reduceSeats(name,seat);
        return "seats reduced..";
    }
}
