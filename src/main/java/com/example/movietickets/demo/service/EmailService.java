package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    private static final Logger logger = Logger.getLogger(EmailService.class.getName());

    public void sendFeedbackEmail(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("buichibao1601@gmail.com");
        message.setSubject("New Feedback from " + feedback.getName());
        message.setText("Name: " + feedback.getName() + "\nEmail: " + feedback.getEmail() + "\nMessage: " + feedback.getMessage());

        try {
            mailSender.send(message);
            logger.info("Email sent successfully.");
        } catch (MailException e) {
            logger.log(Level.SEVERE, "Error sending email: " + e.getMessage(), e);
        }
    }
}