package com.example.movietickets.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEAT")
    private int id;

    @Column(name = "NAME_SEAT", nullable = false)
    private String name;

    @Column(name = "ID_ROOM", nullable = false)
    private String room;
}
