package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
        if (ph == null || season == null) {
            throw new BadRequestException("PH and season must not be null");
        }
        List<Crop> crops = cropRepository.findSuitableCrops(ph, season);
        return crops != null ? crops : new ArrayList<>();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        if (cropNames == null || cropNames.isEmpty()) return new ArrayList<>();
        List<Fertilizer> ferts = new ArrayList<>();
        for (String crop : cropNames) {
            if (StringUtils.hasText(crop)) {
                ferts.addAll(fertilizerRepository.findByCropNameContaining(crop));
            }
        }
        return ferts;
    }

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than PH max");
        }
        if (!List.of("Kharif", "Rabi", "Zaid").contains(crop.getSeason())) {
            throw new BadRequestException("Invalid season: " + crop.getSeason());
        }
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        String npk = fertilizer.getNpkRatio();
        if (!npk.matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("Invalid NPK ratio: " + npk);
        }
        return fertilizerRepository.save(fertilizer);
    }
}
