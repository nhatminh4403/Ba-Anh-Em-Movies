package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Blog;
import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.model.Rating;
import com.example.movietickets.demo.repository.CategoryRepository;
import com.example.movietickets.demo.repository.FilmRepository;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private  final CategoryRepository categoryRepository;
    // Retrieve all film from the database
    public List<Film> getAllFilms() {
        return filmRepository.findAllByOrderByIdDesc();
    }

    public Page<Film> getAllFilmsForUser(Integer pageNo, Integer pageSize, String sortBy) {
        return filmRepository.findAllFilmsForUser(pageNo, pageSize, sortBy);
    }

    // Lấy film theo id

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film getFilmByIdFilm(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id " + id));
    }

    public Optional<Film> getFilmByName(String name){
        return Optional.ofNullable(filmRepository.findByName(name));
    }

    // Thêm film
    public Film addFilm(Film film) throws IOException {

        return filmRepository.save(film);
    }

    public Film updateFilm(Film film) {
        if (film.getId() == null) {
            throw new IllegalArgumentException("Film ID cannot be null for update");
        }
        return filmRepository.save(film);
    }

    // Xóa phim

    public void deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
    }

    // find film by ID
    public Film findFilmById(Long id) {
        Optional<Film> product = filmRepository.findById(id);
        return product.orElseThrow(() -> new FileSystemNotFoundException("Product not found with id: " + id));
    }

    // tính số lượng comment trong 1 trang film
    public long getCommentCount(Long filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + filmId));
        return film.getRatings().size();
    }

    // find film
    public List<Film> searchFilmsByName(String keyword) {
        return filmRepository.searchFilmByName(keyword);
    }

    // tìm theo id country
    public List<Film> getFilmsByCountryId(Long countryId) {
        return filmRepository.findByCountry_Id(countryId);
    }

    // tìm theo id category
    public List<Film> getFilmsByCategoryId(Long categoryId) {
        return filmRepository.findFilmsByCategoryId(categoryId);
    }

    public String getSuggestedMovies() {
        // Lấy danh sách phim từ database
        List<Film> movies = filmRepository.findAll();

        if (movies.isEmpty()) {
            return "Hiện tại không có phim nào trong danh sách.";
        }

        // Chọn ngẫu nhiên 1 phim
        Random random = new Random();

        Film selectedMovie = movies.get(random.nextInt(movies.size()));

        // Tạo câu trả lời với thông tin chi tiết về phim
        StringBuilder response = new StringBuilder();
        response.append("Tôi gợi ý bạn xem phim ")
                .append(selectedMovie.getName())
                .append(". ");

        // Thêm thông tin về thể loại nếu có
        if (selectedMovie.getCategories() != null && !selectedMovie.getCategories().isEmpty()) {
            response.append("Thể loại: ");
            selectedMovie.getCategories().forEach(category ->
                    response.append(category.getName()).append(", "));
            // Xóa dấu phẩy cuối cùng
            response.setLength(response.length() - 2);
            response.append(". ");
        }

        // Thêm thông tin về thời lượng nếu có
        if (selectedMovie.getDuration() > 0) {
            response.append("Thời lượng: ")
                    .append(selectedMovie.getDuration())
                    .append(" phút. ");
        }

        // Thêm mô tả ngắn nếu có
        if (selectedMovie.getDescription() != null && !selectedMovie.getDescription().isEmpty()) {
            response.append("Tóm tắt: ")
                    .append(selectedMovie.getDescription());
        }

        return response.toString();
    }
}
