package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CINEMA_ID")
    private Long id;

    @Column(name = "NAME_CINEMA", nullable = false)
    private String name;

    @Column(name = "NAME_ADDRESS", nullable = false)
    private String address;
}
