package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    // Existing method
    List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season);

    // Add this to match your service implementation
    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);

    Crop addCrop(Crop crop);

    Fertilizer addFertilizer(Fertilizer fertilizer);
}
