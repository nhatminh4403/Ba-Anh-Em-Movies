package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROOM")
    private int id;

    @Column(name = "NAME_ROOM", nullable = false)
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Seat> seats;
}
