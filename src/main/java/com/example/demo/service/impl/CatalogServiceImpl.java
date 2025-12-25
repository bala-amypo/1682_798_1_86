package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;


public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    // Constructor as expected by tests
    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return new ArrayList<>();
    }

    @Override
    public List<Crop> findSuitableCrops(Double latitude, Double longitude, String soilType) {
        return new ArrayList<>();
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizer;
    }

    @Override
    public Crop addCrop(Crop crop) {
        return crop;
    }
}
