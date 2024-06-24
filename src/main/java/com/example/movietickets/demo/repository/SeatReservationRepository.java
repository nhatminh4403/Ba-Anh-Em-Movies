package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    List<SeatReservation> findByScheduleId(Long scheduleId);
    Optional<SeatReservation> findByScheduleIdAndSeatId(Long scheduleId, Long seatId);
}
