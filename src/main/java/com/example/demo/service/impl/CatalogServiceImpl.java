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

    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
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
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        // Assuming Fertilizer has a crop reference or cropName
        return crops.stream()
                .flatMap(crop -> fertilizerRepository.findByCropName(crop.getName()).stream())
                .toList();
    }

    @Override
    public Crop findCropByName(String name) {
        return cropRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Crop not found: " + name));
    }
}
