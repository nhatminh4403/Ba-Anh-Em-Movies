package com.example.movietickets.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @GetMapping
    public String Movie() {
        return "/movie/grid";
    }

    @GetMapping("/details")
    public String Details() {
        return "/movie/details";
    }

    @GetMapping("/checkout")
    public String Checkout() {
        return "/movie/checkout";
    }

    @GetMapping("/seat")
    public String SeatPlan() {
        return "/movie/seat-plan";
    }

    @GetMapping("/ticket")
    public String TicketPlan() {
        return "/movie/ticket-plan";
    }
}