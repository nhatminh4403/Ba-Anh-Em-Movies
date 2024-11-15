package com.example.movietickets.demo.ultillity;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class RemoveDiacritics {
    private static final Pattern VIETNAMESE_ACCENT_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String removeDiacritics(String input) {
        if (input == null) {
            return null;
        }

        // Normalize and remove diacritical marks
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalized = VIETNAMESE_ACCENT_PATTERN.matcher(normalized).replaceAll("");

        // Replace remaining Vietnamese characters that may not decompose
        return replaceVietnameseCharacters(normalized);
    }

    private static String replaceVietnameseCharacters(String input) {
        return input
                .replaceAll("Đ", "D")
                .replaceAll("đ", "d")
                .replaceAll("Ă", "A")
                .replaceAll("ă", "a")
                .replaceAll("Â", "A")
                .replaceAll("â", "a")
                .replaceAll("Ê", "E")
                .replaceAll("ê", "e")
                .replaceAll("Ô", "O")
                .replaceAll("ô", "o")
                .replaceAll("Ơ", "O")
                .replaceAll("ơ", "o")
                .replaceAll("Ư", "U")
                .replaceAll("ư", "u");
    }

}
