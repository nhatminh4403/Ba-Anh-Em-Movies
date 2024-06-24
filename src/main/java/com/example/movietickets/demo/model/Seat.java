package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Column(name = "SEAT_NUMBER")
    private String seatNumber;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IMAGE")
    private String image;

    // Getters and Setters
    // Constructor without parameters
    public Seat() {}

    // Constructor with schedule ID
    public Seat(Long id) {
        this.id = id;
    }

}