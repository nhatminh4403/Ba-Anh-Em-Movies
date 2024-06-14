package com.example.movietickets.demo.model;

import jakarta.persistence.*;

import java.util.Set;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORY")
    private int id;

    @Column(name = "NAME_CATEGORY", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Film> films;
}
