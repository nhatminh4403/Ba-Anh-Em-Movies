package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository  extends JpaRepository<Schedule, Long> {
}
