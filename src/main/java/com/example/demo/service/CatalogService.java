package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Crop saveCrop(Crop crop);

    Fertilizer saveFertilizer(Fertilizer fertilizer);

    List<Fertilizer> getFertilizersByCrop(String cropName);

    List<Crop> getSuitableCrops(String soilType);

    List<Crop> findSuitableCrops(Double ph, Double moisture, String soilType);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
