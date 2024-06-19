package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class FilmService {
    private  final FilmRepository filmRepository;

    // Retrieve all film from the database
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Retrieve a film by its id
    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    // Add a new film to the database
    public Film addFilm(Film film) throws IOException {

        return filmRepository.save(film);
    }

    //find film by ID
    public Film findFilmById(Long id) {
        Optional<Film> product = filmRepository.findById(id);
        return product.orElseThrow(() -> new FileSystemNotFoundException("Product not found with id: " + id));
    }

}
