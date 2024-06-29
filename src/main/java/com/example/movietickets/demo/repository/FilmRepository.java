package com.example.movietickets.demo.repository;


import com.example.movietickets.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepository  extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film f WHERE f.name LIKE %:keyword%")
    List<Film> searchFilmByName(@Param("keyword") String keyword);

    List<Film> findByCountry_Id(Long countryId);

    List<Film> findByCategoryId(Long categoryId);
}
