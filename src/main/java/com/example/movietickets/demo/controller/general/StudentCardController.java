package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.service.OCRService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/student-card")
public class StudentCardController {

    @Autowired
    private OCRService ocrService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadStudentCard(@RequestParam("file") MultipartFile file) {
        try {
            // Trích xuất văn bản từ ảnh thẻ sinh viên
            String extractedText = ocrService.extractTextFromImage(file);

            // Kiểm tra thông tin trường học hoặc mã số sinh viên
            if (extractedText.contains("HUTECH")) {  // thay "Tên Trường Bạn" bằng tên trường thực tế
                return ResponseEntity.ok("Sinh viên hợp lệ, áp dụng giảm giá.");
            } else {
                return ResponseEntity.status(400).body("Thẻ sinh viên không hợp lệ.");
            }
        } catch (IOException | TesseractException e) {
            return ResponseEntity.status(500).body("Lỗi xử lý ảnh.");
        }
    }
}