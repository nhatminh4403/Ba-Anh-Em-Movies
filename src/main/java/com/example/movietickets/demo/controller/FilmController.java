package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Schedule;
import com.example.movietickets.demo.service.CategoryService;
import com.example.movietickets.demo.service.CountryService;
import com.example.movietickets.demo.service.FilmService;
import com.example.movietickets.demo.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@Controller("userFilmController")
public class FilmController {
    @Autowired
    private  final FilmService filmService;
    @Autowired
    private  final CountryService countryService;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final ScheduleService scheduleService;
    // Hiển thị danh sách danh mục
    @GetMapping("/films")
    public String listFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        model.addAttribute("title", "Danh sách film");
        return "/film/film-list";
    }

    @GetMapping("/films/film-details/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        Film film = filmService.findFilmById(id);
        model.addAttribute("film", film);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("countries", countryService.getAllCountries());
        return "film/film-detail";
    }
//    @GetMapping("/films/schedules/{id}")
//    public String listSchedules(Model model) {
//        List<Schedule> schedules = scheduleService.getAllSchedules();
//        model.addAttribute("schedules", schedules);
//        model.addAttribute("title", "Danh sách lịch chiếu");
//        return "/schedule/schedule-list";
//    }


}

