package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT cf FROM Film cf ORDER BY cf.id DESC")
    List<Film> findAllByOrderByIdDesc();
}
