package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories(basePackageClasses = ScheduleRepository.class)
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s JOIN FETCH s.room r JOIN FETCH r.cinema c ORDER BY s.id DESC")
    List<Schedule> findAllWithRoomAndCinema();

    void deleteByFilmId(Long filmId);
    List<Schedule> getSchedulesByFilmId(Long filmId);

    @Query("SELECT s FROM Schedule s WHERE s.film.id = :filmId")
    Schedule findScheduleByFilmId(@Param("filmId") Long filmId);
    List<Schedule> findByFilmId(Long filmId);
    // void getScheduleByFilmId(Long filmId);

    List<Schedule> findByRoomId(Long roomId);
}
