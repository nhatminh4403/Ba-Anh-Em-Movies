package com.example.movietickets.demo.model;

import jakarta.persistence.*;

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRO")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_CAT", referencedColumnName = "ID_CAT")
    private Category category;

    @Column(name = "NAME_PRO", nullable = false)
    private String name;

    @Column(name = "TRAILER", nullable = false)
    private int trailer;

    @Column(name = "DESCRIPTION", nullable = false)
    private int description;

    @Column(name = "POSTER", nullable = false)
    private String poster;

    @Column(name = "ACTOR", nullable = false)
    private String actor;

    @Column(name = "OPENING_DAY", nullable = false)
    private String opening_day;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "COUNTRY_ID", nullable = false)
    private int country_id;

   @Column(name = "RATE_ID", nullable = false)
    private Rate rate_id;
}
