package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.service.CategoryService;
import com.example.movietickets.demo.service.CountryService;
import com.example.movietickets.demo.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String home(Model model,@RequestParam(defaultValue = "0") Integer pageNo,
                       @RequestParam(defaultValue = "9") Integer pageSize,
                       @RequestParam(defaultValue = "id") String sortBy) {
        List<Country> countries = countryService.getAllCountries();
        Page<Film> page = filmService.getAllFilmsForUser(pageNo, pageSize, sortBy);
        List<Film> films = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("countries", countries);
        model.addAttribute("films", films);

        // Add categories to session if they are not already there
        if (!model.containsAttribute("categories")) {
            model.addAttribute("categories", categoryService.getAllCategories());
        }
        return "Home/index";
    }

    /*@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "9") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy

    ) {
        Page<Film> page = filmService.getAllFilmsForUser(pageNo, pageSize, sortBy);
        List<Country> countries = countryService.getAllCountries();
        List<Film> films = page.getContent();
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("categories", categories);
        model.addAttribute("films", films);
        model.addAttribute("countries", countries);
        model.addAttribute("title", "Danh sách film");
        return "Film/film-list";
    }*/
}
