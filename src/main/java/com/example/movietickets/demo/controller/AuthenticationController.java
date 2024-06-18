package com.example.movietickets.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String login() {
        return "/authentication/sign-in";
    }

    @GetMapping("/register")
    public String register() {
        return "/authentication/sign-up";
    }
}
