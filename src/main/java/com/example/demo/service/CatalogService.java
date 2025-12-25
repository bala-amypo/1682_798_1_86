package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    // Add new crop
    Crop addCrop(Crop crop);

    // Add new fertilizer
    Fertilizer addFertilizer(Fertilizer fertilizer);

    // Find suitable crops (example for your logic)
    List<Crop> findSuitableCrops(Double soilPh, Double rainfall, String season);

    // Find fertilizers for given crops
    List<Fertilizer> findFertilizersForCrops(List<Crop> crops);
}
