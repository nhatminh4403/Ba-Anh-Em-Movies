package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.SeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatPriceRepository extends JpaRepository<SeatPrice, Long> {
}
