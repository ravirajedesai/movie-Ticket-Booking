package com.movieTicketBooking.booking_service.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private String movieName;
    private String  bookingName;
    private Long seatToBook;
}
