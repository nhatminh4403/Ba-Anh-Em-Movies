package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Cinema;
import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.Room;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    @Query("SELECT cf FROM Cinema cf ORDER BY cf.id")
    List<Cinema> findAllByOrderById();

    @Query("SELECT c FROM Cinema c LEFT JOIN FETCH c.rooms")
    List<Cinema> findAllWithRooms();
}

