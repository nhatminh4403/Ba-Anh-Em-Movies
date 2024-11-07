package com.example.movietickets.demo.controller.general;

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
        List<Country> countries = countryService.getAllCountries();
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("countries", countries);
        model.addAttribute("films", films);

        // Add categories to session if they are not already there
        if (!model.containsAttribute("categories")) {
            model.addAttribute("categories", categoryService.getAllCategories());
        }
        return "Home/index";
    }
}
