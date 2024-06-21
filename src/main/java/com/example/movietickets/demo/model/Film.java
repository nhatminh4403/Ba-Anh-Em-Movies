
package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "Film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILM_ID")
    private Long id;

    @Column(name = "FILM_NAME", nullable = false)
    private String name;

    @Column(name = "TRAILER")
    private String trailer;  // Changed to String based on assumption

    @Column(name = "DESCRIPTION")
    private String description;  // Changed to String based on assumption

    @Column(name = "POSTER")
    private String poster;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "ACTOR")
    private String actor;


    @Column(name = "OPENING_DAY")
    private LocalDate openingday;  // Changed to camelCase

    @Column(name = "SUBTITLE")
    private String subtitle;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "LIMIT_AGE")
    private String limit_age;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;


}
