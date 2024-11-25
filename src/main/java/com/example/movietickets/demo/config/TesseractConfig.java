package com.example.movietickets.demo.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TesseractConfig {

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        // Đặt đường dẫn tới thư mục chứa file ngôn ngữ
        tesseract.setDatapath("src/main/resources/tessdata/");
        tesseract.setLanguage("vie"); // Ngôn ngữ là tiếng Anh
        return tesseract;
    }
}
