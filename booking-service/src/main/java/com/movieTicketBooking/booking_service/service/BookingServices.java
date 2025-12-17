package com.movieTicketBooking.booking_service.service;

import com.movieTicketBooking.booking_service.dto.BookingRequest;
import com.movieTicketBooking.booking_service.entity.Booking;

import java.util.List;

public interface BookingServices {
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    void deleteBookingById(Long id);
    Booking addBooking(BookingRequest request);
}
