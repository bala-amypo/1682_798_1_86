package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    public boolean validSeason(String season) {
        if (season == null) return false;

        return season.equalsIgnoreCase("Kharif")
                || season.equalsIgnoreCase("Rabi")
                || season.equalsIgnoreCase("Summer");
    }
}
