package com.example.movietickets.demo.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class OCRService {

    @Autowired
    private Tesseract tesseract;

    public String extractTextFromImage(MultipartFile file) throws IOException, TesseractException {
        // Lưu file ảnh tạm thời để OCR
        File tempFile = File.createTempFile("student_card", ".jpg");
        file.transferTo(tempFile);

        // Xử lý OCR
        String extractedText = tesseract.doOCR(tempFile);

        // Xóa file tạm sau khi xử lý xong
        tempFile.delete();

        return extractedText;
    }
}