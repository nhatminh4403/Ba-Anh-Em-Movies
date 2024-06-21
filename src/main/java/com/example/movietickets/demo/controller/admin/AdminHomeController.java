package com.example.movietickets.demo.controller.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    Session se = new Session();

    @GetMapping
    public String index(HttpSession session) {
        if (se.isLoggedIn(session)) {
            return "admin/index";
        }
        return "redirect:/admin/login";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String doLogin(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (se.Login(session, username, password)) {
            return "redirect:/admin";
        }
        return "admin/login";
    }

    @GetMapping("/logout")
    public String Logout(HttpSession session) {
        se.Logout(session);
        return "redirect:/admin/login";
    }
}
