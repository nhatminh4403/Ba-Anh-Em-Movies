package com.example.movietickets.demo.ultillity;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
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
        if (input == null) return "";

        Map<Character, String> vietnameseCharacterMap = new HashMap<>();

        // Vowels with marks
        vietnameseCharacterMap.put('à', "a");
        vietnameseCharacterMap.put('á', "a");
        vietnameseCharacterMap.put('ả', "a");
        vietnameseCharacterMap.put('ã', "a");
        vietnameseCharacterMap.put('ạ', "a");
        vietnameseCharacterMap.put('ă', "a");
        vietnameseCharacterMap.put('ằ', "a");
        vietnameseCharacterMap.put('ắ', "a");
        vietnameseCharacterMap.put('ẳ', "a");
        vietnameseCharacterMap.put('ẵ', "a");
        vietnameseCharacterMap.put('ặ', "a");
        vietnameseCharacterMap.put('â', "a");
        vietnameseCharacterMap.put('ầ', "a");
        vietnameseCharacterMap.put('ấ', "a");
        vietnameseCharacterMap.put('ẩ', "a");
        vietnameseCharacterMap.put('ẫ', "a");
        vietnameseCharacterMap.put('ậ', "a");

        vietnameseCharacterMap.put('è', "e");
        vietnameseCharacterMap.put('é', "e");
        vietnameseCharacterMap.put('ẻ', "e");
        vietnameseCharacterMap.put('ẽ', "e");
        vietnameseCharacterMap.put('ẹ', "e");
        vietnameseCharacterMap.put('ê', "e");
        vietnameseCharacterMap.put('ề', "e");
        vietnameseCharacterMap.put('ế', "e");
        vietnameseCharacterMap.put('ể', "e");
        vietnameseCharacterMap.put('ễ', "e");
        vietnameseCharacterMap.put('ệ', "e");

        vietnameseCharacterMap.put('ì', "i");
        vietnameseCharacterMap.put('í', "i");
        vietnameseCharacterMap.put('ỉ', "i");
        vietnameseCharacterMap.put('ĩ', "i");
        vietnameseCharacterMap.put('ị', "i");

        vietnameseCharacterMap.put('ò', "o");
        vietnameseCharacterMap.put('ó', "o");
        vietnameseCharacterMap.put('ỏ', "o");
        vietnameseCharacterMap.put('õ', "o");
        vietnameseCharacterMap.put('ọ', "o");
        vietnameseCharacterMap.put('ô', "o");
        vietnameseCharacterMap.put('ồ', "o");
        vietnameseCharacterMap.put('ố', "o");
        vietnameseCharacterMap.put('ổ', "o");
        vietnameseCharacterMap.put('ỗ', "o");
        vietnameseCharacterMap.put('ộ', "o");
        vietnameseCharacterMap.put('ơ', "o");
        vietnameseCharacterMap.put('ờ', "o");
        vietnameseCharacterMap.put('ớ', "o");
        vietnameseCharacterMap.put('ở', "o");
        vietnameseCharacterMap.put('ỡ', "o");
        vietnameseCharacterMap.put('ợ', "o");

        vietnameseCharacterMap.put('ù', "u");
        vietnameseCharacterMap.put('ú', "u");
        vietnameseCharacterMap.put('ủ', "u");
        vietnameseCharacterMap.put('ũ', "u");
        vietnameseCharacterMap.put('ụ', "u");
        vietnameseCharacterMap.put('ư', "u");
        vietnameseCharacterMap.put('ừ', "u");
        vietnameseCharacterMap.put('ứ', "u");
        vietnameseCharacterMap.put('ử', "u");
        vietnameseCharacterMap.put('ữ', "u");
        vietnameseCharacterMap.put('ự', "u");

        vietnameseCharacterMap.put('ỳ', "y");
        vietnameseCharacterMap.put('ý', "y");
        vietnameseCharacterMap.put('ỷ', "y");
        vietnameseCharacterMap.put('ỹ', "y");
        vietnameseCharacterMap.put('ỵ', "y");

        vietnameseCharacterMap.put('đ', "d");

        // Uppercase letters
        vietnameseCharacterMap.put('À', "A");
        vietnameseCharacterMap.put('Á', "A");
        vietnameseCharacterMap.put('Ả', "A");
        vietnameseCharacterMap.put('Ã', "A");
        vietnameseCharacterMap.put('Ạ', "A");
        vietnameseCharacterMap.put('Ă', "A");
        vietnameseCharacterMap.put('Ằ', "A");
        vietnameseCharacterMap.put('Ắ', "A");
        vietnameseCharacterMap.put('Ẳ', "A");
        vietnameseCharacterMap.put('Ẵ', "A");
        vietnameseCharacterMap.put('Ặ', "A");
        vietnameseCharacterMap.put('Â', "A");
        vietnameseCharacterMap.put('Ầ', "A");
        vietnameseCharacterMap.put('Ấ', "A");
        vietnameseCharacterMap.put('Ẩ', "A");
        vietnameseCharacterMap.put('Ẫ', "A");
        vietnameseCharacterMap.put('Ậ', "A");

        vietnameseCharacterMap.put('È', "E");
        vietnameseCharacterMap.put('É', "E");
        vietnameseCharacterMap.put('Ẻ', "E");
        vietnameseCharacterMap.put('Ẽ', "E");
        vietnameseCharacterMap.put('Ẹ', "E");
        vietnameseCharacterMap.put('Ê', "E");
        vietnameseCharacterMap.put('Ề', "E");
        vietnameseCharacterMap.put('Ế', "E");
        vietnameseCharacterMap.put('Ể', "E");
        vietnameseCharacterMap.put('Ễ', "E");
        vietnameseCharacterMap.put('Ệ', "E");

        vietnameseCharacterMap.put('Ì', "I");
        vietnameseCharacterMap.put('Í', "I");
        vietnameseCharacterMap.put('Ỉ', "I");
        vietnameseCharacterMap.put('Ĩ', "I");
        vietnameseCharacterMap.put('Ị', "I");

        vietnameseCharacterMap.put('Ò', "O");
        vietnameseCharacterMap.put('Ó', "O");
        vietnameseCharacterMap.put('Ỏ', "O");
        vietnameseCharacterMap.put('Õ', "O");
        vietnameseCharacterMap.put('Ọ', "O");
        vietnameseCharacterMap.put('Ô', "O");
        vietnameseCharacterMap.put('Ồ', "O");
        vietnameseCharacterMap.put('Ố', "O");
        vietnameseCharacterMap.put('Ổ', "O");
        vietnameseCharacterMap.put('Ỗ', "O");
        vietnameseCharacterMap.put('Ộ', "O");
        vietnameseCharacterMap.put('Ơ', "O");
        vietnameseCharacterMap.put('Ờ', "O");
        vietnameseCharacterMap.put('Ớ', "O");
        vietnameseCharacterMap.put('Ở', "O");
        vietnameseCharacterMap.put('Ỡ', "O");
        vietnameseCharacterMap.put('Ợ', "O");

        vietnameseCharacterMap.put('Ù', "U");
        vietnameseCharacterMap.put('Ú', "U");
        vietnameseCharacterMap.put('Ủ', "U");
        vietnameseCharacterMap.put('Ũ', "U");
        vietnameseCharacterMap.put('Ụ', "U");
        vietnameseCharacterMap.put('Ư', "U");
        vietnameseCharacterMap.put('Ừ', "U");
        vietnameseCharacterMap.put('Ứ', "U");
        vietnameseCharacterMap.put('Ử', "U");
        vietnameseCharacterMap.put('Ữ', "U");
        vietnameseCharacterMap.put('Ự', "U");

        vietnameseCharacterMap.put('Ỳ', "Y");
        vietnameseCharacterMap.put('Ý', "Y");
        vietnameseCharacterMap.put('Ỷ', "Y");
        vietnameseCharacterMap.put('Ỹ', "Y");
        vietnameseCharacterMap.put('Ỵ', "Y");

        vietnameseCharacterMap.put('Đ', "D");

        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            result.append(vietnameseCharacterMap.getOrDefault(ch, String.valueOf(ch)));
        }

        return result.toString();
    }
}
