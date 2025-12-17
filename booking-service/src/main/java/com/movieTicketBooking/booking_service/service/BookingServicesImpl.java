package com.movieTicketBooking.booking_service.service;

import com.movieTicketBooking.booking_service.dto.BookingRequest;
import com.movieTicketBooking.booking_service.dto.Movieresponse;
import com.movieTicketBooking.booking_service.entity.Booking;
import com.movieTicketBooking.booking_service.feignClient.MovieClient;
import com.movieTicketBooking.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServicesImpl implements BookingServices{

    private final BookingRepository repository;
    private final MovieClient client;

    @Override
    public List<Booking> getAllBookings() {
        List<Booking>all=repository.findAll();
        return all;
    }
    @Override
    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking Not Found.."));
    }
    @Override
    public void deleteBookingById(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Booking addBooking(BookingRequest request) {
        Movieresponse response=client.getMovieByName(request.getMovieName());

        client.reduceMovieSeats(response.getMovieName(),request.getSeatToBook());

            Booking book=new Booking();
        book.setBookingName(request.getBookingName());
        book.setBookingSeat(request.getSeatToBook());
        book.setMovieName(request.getMovieName());
        book.setMovieRate(response.getRate());
        book.setTotalBill(request.getSeatToBook()* response.getRate());
        return repository.save(book);
    }
}
