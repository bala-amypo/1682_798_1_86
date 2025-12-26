package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Crop saveCrop(Crop crop);

    // 🔹 ADD THESE METHODS
    List<Crop> findSuitableCrops(Double soilPH, Double waterAvailability, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
