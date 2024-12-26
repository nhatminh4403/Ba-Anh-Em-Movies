package com.example.movietickets.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Long id;

    @Column(name="promotion_code",nullable = false)
    private String promotionCode;

    @Column(name="promotion_description",nullable = false,length = 350)
    private String promotionDescription;

    @Column(nullable = false,name = "promotion_start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date promotionStartDate;

    @Column(nullable = false,name = "promotion_end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date promotionEndDate;

    @Column(nullable = false,name = "promotion_discount_rate")
    private Double promotionDiscountRate;

    @Column(name = "point_to_redeem")
    private Long pointToRedeem = 0L;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "promotions",  cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<User> user;
}
