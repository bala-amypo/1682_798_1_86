package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {
    
    // Existing methods
    Crop addCrop(Crop crop);
    Fertilizer addFertilizer(Fertilizer fertilizer);
    List<Fertilizer> findFertilizersForCrops(List<Crop> crops);

    // NEW helper method
    Crop findCropByName(String name);
}
