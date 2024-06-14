package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_FILM", referencedColumnName = "ID_FILM")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM", referencedColumnName = "ID_ROOM")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "ID_SCHEDULE", referencedColumnName = "ID_SCHEDULE")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "ID_CINEMA", referencedColumnName = "ID_CINEMA")
    private Cinema cinema;
}
