package com.example.movietickets.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int id;

    @Column(name = "ID_FILM", nullable = false)
    private String film_id;

    @Column(name = "ID_ROOM", nullable = false)
    private String room_id;

    @Column(name = "ID_SCHEDULE", nullable = false)
    private String schedule_id;

    @Column(name = "ID_CINEMA", nullable = false)
    private String cinema_id;
}
