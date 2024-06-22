package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendFeedbackEmail(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("buichibao1601@gmail.com");
        message.setSubject("New Feedback from " + feedback.getName());
        message.setText("Name: " + feedback.getName() + "\nEmail: " + feedback.getEmail() + "\nMessage: " + feedback.getMessage());

        mailSender.send(message);
    }
}
