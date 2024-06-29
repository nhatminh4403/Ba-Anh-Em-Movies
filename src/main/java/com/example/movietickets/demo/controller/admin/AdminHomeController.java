package com.example.movietickets.demo.controller.admin;

import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminHomeController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        Long getUserCount = userService.getCountUser();
        model.addAttribute("userCount", getUserCount);
        return "/admin/home/index";
    }
}
