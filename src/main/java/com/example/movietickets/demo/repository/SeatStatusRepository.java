package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface SeatStatusRepository extends JpaRepository<SeatStatus, Long> {
    List<SeatStatus> findByScheduleId(Long scheduleId);
}