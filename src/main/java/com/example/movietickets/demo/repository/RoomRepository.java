package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT cf FROM Room cf ORDER BY cf.id DESC")
    List<Room> findAllByOrderById();

    Room findByName(String name);
    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.seats WHERE r.cinema.id = :cinemaId")
    List<Room> findByCinemaIdWithSeats(@Param("cinemaId") Long cinemaId);


}
