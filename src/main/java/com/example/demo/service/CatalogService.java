package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {
    List<Crop> getAllCrops();
    List<Fertilizer> getFertilizersByCrop(String cropName);

    // Add these to fix SuggestionServiceImpl compilation
    List<Crop> findSuitableCrops(Double nitrogen, Double phosphorus, String soilType);
    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
