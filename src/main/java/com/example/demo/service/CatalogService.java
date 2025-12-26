package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    // Existing
    Crop saveCrop(Crop crop);

    // Fertilizer methods
    Fertilizer saveFertilizer(Fertilizer fertilizer);
    List<Fertilizer> getFertilizersByCrop(String cropName);

    // Crop methods
    List<Crop> getSuitableCrops(String soilType);

    // Add for SuggestionService
    List<Crop> findSuitableCrops(Double ph, Double moisture, String soilType);
    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
