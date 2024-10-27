package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.service.CategoryService;
import com.example.movietickets.demo.service.CountryService;
import com.example.movietickets.demo.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    @Autowired
    private final CategoryService categoryService;

    @Autowired
    private final FilmService filmService;

    @Autowired
    private final CountryService countryService;

    @GetMapping("/")
    public String home(Model model) {

        List<Category> categories = categoryService.getAllCategories();
        List<Country> countries = countryService.getAllCountries();
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("categories", categories);
        model.addAttribute("countries", countries);
        model.addAttribute("films", films);
        return "/home/index";
    }
}
