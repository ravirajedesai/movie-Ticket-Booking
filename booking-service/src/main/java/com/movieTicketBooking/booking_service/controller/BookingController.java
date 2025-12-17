package com.movieTicketBooking.booking_service.controller;

import com.movieTicketBooking.booking_service.dto.BookingRequest;
import com.movieTicketBooking.booking_service.dto.Movieresponse;
import com.movieTicketBooking.booking_service.entity.Booking;
import com.movieTicketBooking.booking_service.service.BookingServices;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServices services;

    @GetMapping
    ResponseEntity<List<Booking>>getAllBooking(){
        List<Booking> get=services.getAllBookings();
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }
    @GetMapping("/{id}")
    ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        Booking get=services.getBookingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        services.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Booking> addBooking(@RequestBody BookingRequest request){
        Booking add=services.addBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(add);
    }


}
