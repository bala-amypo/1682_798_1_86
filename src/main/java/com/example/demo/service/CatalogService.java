package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    List<Crop> findSuitableCrops(Double soilPH, Double waterAvailability, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);

    // Add this method
    Crop saveCrop(Crop crop);
}
