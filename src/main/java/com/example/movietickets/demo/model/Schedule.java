package com.example.movietickets.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDULE")
    private int id;

    @Column(name = "ROOM_FILM", nullable = false)
    private String film_id;

    @Column(name = "ID_CINEMA", nullable = false)
    private String cinema_id;

    @Column(name = "ID_ROOM", nullable = false)
    private List<Room> rooms_id;

    @Column(name = "START_TIME", nullable = false)
    private String start_time;

}
