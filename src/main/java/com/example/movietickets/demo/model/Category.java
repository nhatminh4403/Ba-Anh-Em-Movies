package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "Category")
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
