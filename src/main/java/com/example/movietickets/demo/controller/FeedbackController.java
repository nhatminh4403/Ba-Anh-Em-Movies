package com.example.movietickets.demo.controller;

import com.example.movietickets.demo.model.Feedback;
import com.example.movietickets.demo.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class FeedbackController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/feedback")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback/feedback-form";
    }

    @PostMapping("/feedback")
    public String submitForm(@Valid Feedback feedback, BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            return "feedback/feedback-form";
        }*/

        // Gửi email phản hồi tới admin
        emailService.sendFeedbackEmail(feedback);

        model.addAttribute("message", "Feedback submitted successfully");
        return "redirect:/about";
    }
}
