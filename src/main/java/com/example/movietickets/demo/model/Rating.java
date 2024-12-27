package com.example.movietickets.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATING_ID")
    private Long id;

    @Column(name = "RATING_CONTENT")
    private String content;

    @Column(name = "RATING_DAYCREATE")
    private LocalDateTime date;

    @Column(name = "RATING_STAR")
    private int star;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    @JsonBackReference
    @JsonIgnore
    private Film film;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonIgnore
    private User user;

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return date.format(formatter);
    }

}
