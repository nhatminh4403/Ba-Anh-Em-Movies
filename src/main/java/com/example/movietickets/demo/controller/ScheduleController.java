package com.example.movietickets.demo.controller;


import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.service.FilmService;
import com.example.movietickets.demo.service.RoomService;
import com.example.movietickets.demo.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller("userScheduleController")
public class ScheduleController {
    @Autowired
    private final ScheduleService scheduleService;
    @Autowired
    private final FilmService filmService;
    @Autowired
    private final RoomService roomService;

    @GetMapping("/schedules/{id}")
    public String scheduleDetail(@PathVariable Long id, Model model) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        model.addAttribute("schedule", schedule);
        model.addAttribute("title", "Chi tiết lịch chiếu");
        model.addAttribute("films", filmService.getAllFilms());
        model.addAttribute("rooms", roomService.getAllRooms());
        return "/schedule/schedule-detail";
    }



}
