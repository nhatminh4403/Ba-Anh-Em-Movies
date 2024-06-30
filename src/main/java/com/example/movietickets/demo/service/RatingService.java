package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Comment;
import com.example.movietickets.demo.model.Rating;
import com.example.movietickets.demo.repository.CommentRepository;
import com.example.movietickets.demo.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public List<Rating> getAllRatingByFilmId(Long FilmId) {
        return ratingRepository.findAllByFilmId(FilmId);
    }

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public void deleteRating(Long id) {
        if (!ratingRepository.existsById(id)) {
            throw new IllegalStateException("Rating with ID " + id + " does not exist.");
        }
        ratingRepository.deleteById(id);
    }

    public boolean hasUserRatedFilm(String username, Long filmId) {
        return ratingRepository.existsByUserUsernameAndFilmId(username, filmId);
    }

    public Double getAverageRating(Long filmId) {
        return ratingRepository.findAverageRatingByFilmId(filmId);
    }
}
