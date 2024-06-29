package com.example.movietickets.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_CONTENT")
    private String content;

    @Column(name = "COMMENT_DAYCREAT")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        return date.format(formatter);
    }

}
