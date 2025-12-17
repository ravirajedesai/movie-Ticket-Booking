package com.movieTicketBooking.booking_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(nullable = false)
    private String BookingName;
    @Column(nullable = false)
    private Long bookingSeat;

    private String movieName;
    private Long movieRate;
    private Long totalBill;
//    private Long availableSeat;
}
