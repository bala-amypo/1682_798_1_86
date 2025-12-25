package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    // ------------------ Crop Methods ------------------
    @Override
    public Crop addCrop(Crop crop) {
        // Validate PH range
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than PH max");
        }

        // Validate season
        if (!List.of("Kharif", "Rabi", "Zaid").contains(crop.getSeason())) {
            throw new BadRequestException("Invalid season. Allowed: Kharif, Rabi, Zaid");
        }

        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
        // Call repository to fetch crops matching PH range and season
        return cropRepository.findSuitableCrops(ph, season);
    }

    // ------------------ Fertilizer Methods ------------------
    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        // Validate NPK ratio format
        if (!fertilizer.getNpkRatio().matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("Invalid NPK ratio. Must be in format X-Y-Z");
        }

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        List<Fertilizer> result = new ArrayList<>();
        for (String crop : crops) {
            // ✅ Use correct repository method
            result.addAll(fertilizerRepository.findByRecommendedForCropsContaining(crop));
        }
        return result;
    }
}
