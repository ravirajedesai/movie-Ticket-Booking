package com.movieTicketBooking.booking_service.feignClient;

import com.movieTicketBooking.booking_service.dto.Movieresponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movie-service",url="http://localhost:8080")
public interface MovieClient {

    @GetMapping("/movie/name/{name}")
    Movieresponse getMovieByName(@PathVariable(name = "name") String name);

    @PutMapping("/movie/name/{name}/seat")
    String reduceMovieSeats(@PathVariable(name = "name")String name,
                            @RequestParam(name = "seat")Long seat);
}
