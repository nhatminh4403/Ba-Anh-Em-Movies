package com.example.movietickets.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CINEMA")
    private int id;

    @Column(name = "NAME_CINEMA", nullable = false)
    private String name;

    @Column(name = "NAME_ADDRESS", nullable = false)
    private String address;
}
