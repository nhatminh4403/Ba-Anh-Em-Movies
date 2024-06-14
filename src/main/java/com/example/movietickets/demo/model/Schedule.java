package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCHEDULE")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_FILM", referencedColumnName = "ID_FILM")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "ID_CINEMA", referencedColumnName = "ID_CINEMA")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM", referencedColumnName = "ID_ROOM")
    private Room room;

    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;
}
