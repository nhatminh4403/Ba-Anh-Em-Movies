package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RATE")
    private int id;

    @Column(name = "NAME_RATE", nullable = false)
    private String name;
}
