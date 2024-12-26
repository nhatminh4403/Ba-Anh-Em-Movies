package com.example.movietickets.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILM_ID")
    private Long id;

    @Column(name = "FILM_NAME", nullable = false)
    private String name;

    @Column(name = "TRAILER")
    private String trailer;

    @Column(name = "DESCRIPTION", length = 10000)
    private String description;

    @Column(name = "POSTER")
    private String poster;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "OPENING_DAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date openingday;

    @Column(name = "SUBTITLE")
    private String subtitle;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "LIMIT_AGE")
    private String limit_age;

    @Column(name = "QUANLITY")
    private String quanlity;

    @ManyToOne
    @JoinColumn(name = "country_id")

    private Country country;

    @ManyToMany
    @JoinTable(
            name = "Film_Category",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    @JsonBackReference
    private List<Category> categories = new ArrayList<>();

    @Transient
    private List<Long> categoryIds = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rating> ratings;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Schedule> schedules;

    public List<String> getActorList() {
        if (actor == null || actor.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(actor.split("\\s*,\\s*"));
    }

    @Override
    public String toString() {
        return "Film{id=" + id + ", name='" + name + "'}";
    }
}
