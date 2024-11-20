package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        // return scheduleRepository.findAll();
        return scheduleRepository.findAllWithRoomAndCinema();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }

    public void deleteByFilmId(Long filmId) {
        scheduleRepository.deleteByFilmId(filmId);
    }


    public List<Schedule> getSchedulesByFilmId(Long filmId) {
        return scheduleRepository.findByFilmId(filmId);
    }


    public Schedule findScheduleByFilmId(Long filmId) {
        return scheduleRepository.findByFilmId(filmId)
                .stream()
                .findFirst() // Or choose logic for multiple schedules
                .orElseThrow(() -> new IllegalArgumentException("No schedule found for film ID " + filmId));
    }
}
