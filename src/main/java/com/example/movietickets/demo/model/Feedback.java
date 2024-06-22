package com.example.movietickets.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "FeedBack")
public class Feedback {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID")
    private Long id;


    @Column(name = "FEEDBACK_NAME")
    @NotBlank(message = "Name is required")
    private String name;


    @Column(name = "FEEDBACK_EMAIL")
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;


    @Column(name = "FEEDBACK_MESSAGE")
    @NotBlank(message = "Message is required")
    private String message;
}
