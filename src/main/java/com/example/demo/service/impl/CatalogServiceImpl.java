package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double soilPh, Double rainfall, String season) {
        // Replace with your logic, this is just a placeholder
        return cropRepository.findAll();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        // Example placeholder: collect fertilizers by crop names
        return crops.stream()
                .flatMap(crop -> fertilizerRepository.findByCropNameContaining(crop.getName()).stream())
                .toList();
    }
}
