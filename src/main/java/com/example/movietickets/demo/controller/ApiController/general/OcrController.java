package com.example.movietickets.demo.controller.ApiController.general;


import com.example.movietickets.demo.model.User;
import com.example.movietickets.demo.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/ocr")
public class OcrController {

    @Autowired
    private OCRService ocrService;

    @PostMapping("/scan")
    public ResponseEntity<?> scanStudentCard(@RequestParam("image") MultipartFile file) {
        try {
            User studentInfo = ocrService.extractCardInfo(file);
            Map<String, Object> response = new HashMap<>();
            response.put("fullName", studentInfo.getFullname());
            response.put("birthday", studentInfo.getBirthday());
            response.put("age", calculateAge(studentInfo.getBirthday()));
//            response.put("nienKhoa", studentInfo.getNienKhoa());
//            response.put("fullText", studentInfo.getFullText());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
    public int calculateAge(String birthday) {
        if (birthday == null || birthday.isEmpty()) {
            return 0;
        }

        try {
            // Chuyển đổi String ngày sinh sang LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(birthday, formatter);
            LocalDate currentDate = LocalDate.now();

            return Period.between(birthDate, currentDate).getYears();
        } catch (Exception e) {
            return 0;
        }
    }
}
