package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "CINEMA_ID")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;
}
