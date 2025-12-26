package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    // Existing
    Crop saveCrop(Crop crop);

    // Add these methods
    Fertilizer saveFertilizer(Fertilizer fertilizer);

    List<Fertilizer> getFertilizersByCrop(String cropName);

    List<Crop> getSuitableCrops(String soilType);
}
