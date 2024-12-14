package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findBySymbolInAndRoom(List<String> symbols, Room room);

    List<Seat> findByRoomId(Long roomId);

    List<Seat> findByRoom(Room room);
    // This query should ensure distinct results
    @Query("SELECT DISTINCT s FROM Seat s WHERE s.room.id = :roomId")
    List<Seat> findDistinctSeatsByRoomId(@Param("roomId") Long roomId);

    List<Seat> getSeatByRoomId(Long roomId);

    @Query("SELECT s FROM Seat s " +
            "LEFT JOIN BookingDetail bd ON s.id = bd.seat.id " +
            "WHERE s.room.id = :roomId AND (bd.schedule.id = :scheduleId OR :scheduleId IS NULL)")
    List<Seat> findSeatsByRoomAndSchedule(@Param("roomId") Long roomId, @Param("scheduleId") Long scheduleId);

    @Query("SELECT s FROM Seat s WHERE s.room.id = (SELECT sc.room.id FROM Schedule sc WHERE sc.id = :scheduleId)")
    List<Seat> findSeatsByScheduleId(@Param("scheduleId") Long scheduleId);

}
