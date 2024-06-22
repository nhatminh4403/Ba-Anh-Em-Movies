package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;


@Data
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "SEAT")
    private String seat;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
