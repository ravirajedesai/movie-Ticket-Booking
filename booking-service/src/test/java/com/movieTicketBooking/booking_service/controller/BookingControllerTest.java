package com.movieTicketBooking.booking_service.controller;

import com.movieTicketBooking.booking_service.dto.BookingRequest;
import com.movieTicketBooking.booking_service.entity.Booking;
import com.movieTicketBooking.booking_service.service.BookingServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingServices bookingServices;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addBookingTest() throws Exception {

        BookingRequest request = new BookingRequest();
        request.setMovieName("Avatar");

        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingServices.addBooking(request)).thenReturn(booking);

        mockMvc.perform(post("/booking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
