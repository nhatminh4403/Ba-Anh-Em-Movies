package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.model.Seat;
import com.example.movietickets.demo.model.SeatReservation;
import com.example.movietickets.demo.repository.SeatRepository;
import com.example.movietickets.demo.repository.SeatReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatReservationRepository seatReservationRepository;

    public List<Seat> getSeatsByRoomId(Long roomId) {
        return seatRepository.findByRoomId(roomId);
    }

    public List<SeatReservation> getSeatReservationsByScheduleId(Long scheduleId) {
        return seatReservationRepository.findByScheduleId(scheduleId);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long seatId) {
        seatRepository.deleteById(seatId);
    }

    public Seat getSeatById(Long seatId) {
        return seatRepository.findById(seatId).orElse(null);
    }

    public void reserveSeat(Long scheduleId, Long seatId) {
        SeatReservation reservation = seatReservationRepository.findByScheduleIdAndSeatId(scheduleId, seatId)
                .orElse(new SeatReservation());
        reservation.setSchedule(new Schedule(scheduleId));
        reservation.setSeat(new Seat(seatId));
        reservation.setReserved(true);
        seatReservationRepository.save(reservation);
    }
}