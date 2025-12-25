package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        // Dummy implementation for tests
        return new ArrayList<>();
    }

    @Override
    public List<Crop> findSuitableCrops(Double latitude, Double longitude, String soilType) {
        // Dummy implementation for tests
        return new ArrayList<>();
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        // Must return Fertilizer as per interface
        return fertilizer;
    }

    @Override
    public Crop addCrop(Crop crop) {
        // Must return Crop as per interface
        return crop;
    }
}
