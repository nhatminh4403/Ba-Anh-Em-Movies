package com.example.movietickets.demo.model;

import jakarta.persistence.*;

import java.util.Set;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USERS")
    private int id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @OneToMany(mappedBy = "user")
    private Set<Cart> carts;

}
