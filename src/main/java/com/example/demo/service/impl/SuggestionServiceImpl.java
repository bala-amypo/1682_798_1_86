package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl {

    private final CatalogService catalogService;

    public SuggestionServiceImpl(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public List<Fertilizer> suggestFertilizers(List<String> cropNames) {
        // Convert Strings to Crop entities
        List<Crop> crops = cropNames.stream()
                .map(catalogService::findCropByName)
                .collect(Collectors.toList());

        // Fetch fertilizers
        return catalogService.findFertilizersForCrops(crops);
    }
}
