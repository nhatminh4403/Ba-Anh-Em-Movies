package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "SeatPrice")
public class SeatPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRICE")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

}
