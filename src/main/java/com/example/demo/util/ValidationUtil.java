package com.example.demo.util;

import java.util.*;

public class ValidationUtil {
    private static final List<String> SEASONS =
            Arrays.asList("Kharif", "Rabi", "Summer");

    public static boolean validSeason(String season) {
        return SEASONS.contains(season);
    }
}
