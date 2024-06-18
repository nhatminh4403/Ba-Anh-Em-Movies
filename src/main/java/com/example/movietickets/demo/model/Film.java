<<<<<<< Updated upstream
package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FILM")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORY", referencedColumnName = "ID_CATEGORY")
    private Category category;

    @Column(name = "NAME_FILM", nullable = false)
    private String name;

    @Column(name = "TRAILER", nullable = false)
    private String trailer;  // Changed to String based on assumption

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;  // Changed to String based on assumption

    @Column(name = "POSTER", nullable = false)
    private String poster;

    @Column(name = "ACTOR", nullable = false)
    private String actor;

    @Column(name = "OPENING_DAY", nullable = false)
    private String openingDay;  // Changed to camelCase

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @Column(name = "COUNTRY_ID", nullable = false)
    private int countryId;  // Changed to camelCase

    @ManyToOne
    @JoinColumn(name = "ID_RATE", referencedColumnName = "ID_RATE")
    private Rate rate;
=======
package com.example.movietickets.demo.model;public class Film {
>>>>>>> Stashed changes
}
