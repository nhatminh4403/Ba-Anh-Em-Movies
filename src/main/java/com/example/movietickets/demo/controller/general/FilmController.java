package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Rating;
import com.example.movietickets.demo.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
    private final ScheduleServiceImpl scheduleService;
    @Autowired
    private final RatingService ratingService;


    // Hiển thị danh sách danh mục
    @GetMapping("/films")
    public String listFilms(Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
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
    }

    @GetMapping("/films/film-details/{id}")
    public String getFilmDetail(@PathVariable Long id, Model model) {
        Film film = filmService.findFilmById(id);
        List<Rating> ratings = ratingService.getAllRatingByFilmId(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // kiểm tra xem người dùng đó comment chưa
        boolean hasRated = ratingService.hasUserRatedFilm(currentUsername, film.getId());
        model.addAttribute("hasRated", hasRated);

        // tính số lượng trung bình star
        Double averageRating = ratingService.getAverageRating(film.getId());
        int averageRatingInteger = (int) Math.floor(averageRating != null ? averageRating : 0);
        model.addAttribute("averageRating", averageRatingInteger);

        // Tính số lượng rating
        int numberOfRatings = ratings.size();

        model.addAttribute("numberOfRatings", numberOfRatings);
        model.addAttribute("film", film);
        model.addAttribute("ratings", ratings);
        model.addAttribute("rating", new Rating());
        List<String> actors = film.getActorList();
        model.addAttribute("film", film);
        model.addAttribute("actors", actors);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("countries", countryService.getAllCountries());

        return "Film/film-detail";
    }

    @GetMapping("/films/by-country")
    public String getFilmsByCountry(Model model, @RequestParam("countryId") Long countryId) {
        List<Film> films = filmService.getFilmsByCountryId(countryId);
        List<Country> countries = countryService.getAllCountries();
        List<Category> categories = categoryService.getAllCategories();


        model.addAttribute("categories", categories);
        model.addAttribute("films", films);
        model.addAttribute("countries", countries);
        model.addAttribute("countryId", countryId);
        return "Film/films-by-country";
    }

    @GetMapping("/films/by-category/{id}")
    public String getFilmsByCategory(Model model, @PathVariable("id") Long categoryId) {
        List<Film> films = filmService.getFilmsByCategoryId(categoryId);
        List<Country> countries = countryService.getAllCountries();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);


        model.addAttribute("films", films);
        model.addAttribute("countries", countries);
        return "Film/films-by-category";  // Tên template view để hiển thị danh sách phim theo category
    }
    @GetMapping("/films/search")
    public String searchFilm(@RequestParam("keyword") String keyword, Model model) {
        List<Film> filmsByName = filmService.searchFilmsByName(keyword);
        model.addAttribute("keyword",keyword);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("countries",countryService.getAllCountries());
        model.addAttribute("filmsByName", filmsByName);
        return "Film/film-search";
    }
}

