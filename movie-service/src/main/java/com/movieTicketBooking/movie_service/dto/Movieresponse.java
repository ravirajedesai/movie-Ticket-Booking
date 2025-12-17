package com.movieTicketBooking.movie_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movieresponse {
    private String movieName;
    private Long rate;
}
