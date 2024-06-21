package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepository extends JpaRepository<ScheduleDetail, Long> {
}
