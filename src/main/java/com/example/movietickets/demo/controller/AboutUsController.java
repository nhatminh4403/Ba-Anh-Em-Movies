package com.example.movietickets.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/about")
    public String about() {
        return "/about/about-us";
    }
}
