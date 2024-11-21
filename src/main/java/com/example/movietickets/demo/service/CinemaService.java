package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Cinema;
import com.example.movietickets.demo.model.Room;
import com.example.movietickets.demo.repository.CinemaRepository;
import com.example.movietickets.demo.repository.RoomRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAllByOrderById();
    }

    public Optional<Cinema> getCinemaById(Long id) {
        return cinemaRepository.findById(id);
    }

    public void addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    public void updateCinema(@NotNull Cinema cinema) {
        Cinema existingCinema = cinemaRepository.findById(cinema.getId())
                .orElseThrow(() -> new IllegalStateException("Cinema with ID " + cinema.getId() + " does not exist."));
        existingCinema.setName(cinema.getName());
        existingCinema.setAddress(cinema.getAddress());
        existingCinema.setMap(cinema.getMap());
        cinemaRepository.save(existingCinema);
    }

    public void deleteCinemaById(Long id) {
        if (!cinemaRepository.existsById(id)) {
            throw new IllegalStateException("Cinema with ID " + id + " does not exist.");
        }
        cinemaRepository.deleteById(id);
    }

    public List<Cinema> findAllWithRooms() {
        // Fetch tất cả các rạp và kèm danh sách phòng
        return cinemaRepository.findAllWithRooms();
    }
    public Cinema findCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cinema with ID " + id + " does not exist."));
    }
}