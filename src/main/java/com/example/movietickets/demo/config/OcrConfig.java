package com.example.movietickets.demo.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OcrConfig {

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:/Users/ADmin/AppData/Local/Programs/Tesseract-OCR/tessdata");
        tesseract.setLanguage("vie");
        tesseract.setTessVariable("user_defined_dpi", "300");
        return tesseract;
    }
}