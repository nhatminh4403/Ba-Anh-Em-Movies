package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "User")
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
    private Set<CartItem> carts;
}
