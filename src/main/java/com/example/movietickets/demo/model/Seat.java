package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEAT")
    private int id;

    @Column(name = "NAME_SEAT", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM", referencedColumnName = "ID_ROOM", nullable = false)
    private Room room;
}
