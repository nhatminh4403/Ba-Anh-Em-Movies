package com.example.movietickets.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTITEM")
    private int id;


    @ManyToOne
    @JoinColumn(name = "FILM_ID", referencedColumnName = "ID_FILM")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM", referencedColumnName = "ID_ROOM")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "ID_SCHEDULE", referencedColumnName = "ID_SCHEDULE")
    private Schedule schedule;

}
