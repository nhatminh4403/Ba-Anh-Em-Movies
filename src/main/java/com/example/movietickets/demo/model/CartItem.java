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
    @JoinColumn(name = "ID_USERS", referencedColumnName = "ID_USERS")
    private User user;

}
