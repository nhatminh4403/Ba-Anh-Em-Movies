package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
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
}

