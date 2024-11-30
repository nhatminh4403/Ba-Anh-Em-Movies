package com.example.movietickets.demo.controller.ApiController.admin;

import com.example.movietickets.demo.model.Cinema;
import com.example.movietickets.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminCinemaApiController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas/{selectedCinemaId}")
    public ResponseEntity<Cinema> showCinema(@PathVariable(required = false) Long selectedCinemaId) {

        List<Cinema> cinemas = cinemaService.findAllWithRooms();
        Cinema selectedCinema = selectedCinemaId != null
                ? cinemaService.findCinemaById(selectedCinemaId)
                : (cinemas.isEmpty() ? null : cinemas.get(0));
        return ResponseEntity.ok(selectedCinema);
    }
}
