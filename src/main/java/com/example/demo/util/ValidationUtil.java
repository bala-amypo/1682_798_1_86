package com.example.demo.util;

import java.util.List;

public class ValidationUtil {
    private static final List<String> VALID_SEASONS = List.of("Kharif", "Rabi", "Summer");

    public static boolean validSeason(String season) {
        return VALID_SEASONS.contains(season);
    }

    public static boolean validNPK(String npk) {
        return npk.matches("\\d+-\\d+-\\d+");
    }
}
