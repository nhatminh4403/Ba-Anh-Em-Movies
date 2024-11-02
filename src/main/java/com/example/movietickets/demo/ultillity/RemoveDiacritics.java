package com.example.movietickets.demo.ultillity;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class RemoveDiacritics {
    private static final Pattern VIETNAMESE_ACCENT_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String removeDiacritics(String input) {
        if (input == null) {
            return null;
        }

        // Chuyển chuỗi về dạng bình thường và loại bỏ dấu
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return VIETNAMESE_ACCENT_PATTERN.matcher(normalized).replaceAll("");
    }
}
