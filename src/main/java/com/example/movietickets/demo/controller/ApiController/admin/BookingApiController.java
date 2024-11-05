package com.example.movietickets.demo.controller.ApiController.admin;


import com.example.movietickets.demo.model.Booking;
import com.example.movietickets.demo.service.APIService.AdminApiService;
import com.example.movietickets.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class BookingApiController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AdminApiService adminApiService;

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
        System.out.println("Received request for booking ID: " + id);

        try{
            Long idNumber = Long.parseLong(id);
            Optional<Booking> booking = adminApiService.getBookingId(idNumber);
            System.out.println("Parsed booking ID: " + idNumber);
            return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
        catch (Exception e){
            System.out.println("Error processing booking ID: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
