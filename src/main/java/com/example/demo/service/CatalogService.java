package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    List<Crop> getAllCrops();

    List<Crop> findSuitableCrops(Double nitrogen, Double phosphorus, String soilType);

    List<Fertilizer> getAllFertilizers();

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);

    // Add this to match your interface
    List<Fertilizer> getFertilizersByCrop(String cropName);
}
