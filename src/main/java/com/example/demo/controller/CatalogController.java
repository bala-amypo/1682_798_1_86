package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/addCrop")
    public Crop addCrop(@RequestBody Crop crop) {
        return catalogService.addCrop(crop);
    }

    @PostMapping("/addFertilizer")
    public Fertilizer addFertilizer(@RequestBody Fertilizer fertilizer) {
        return catalogService.addFertilizer(fertilizer);
    }

    @PostMapping("/fertilizersForCrops")
    public List<Fertilizer> getFertilizersForCrops(@RequestBody List<String> cropNames) {
        // Convert crop names to Crop objects
        List<Crop> crops = cropNames.stream()
                .map(catalogService::findCropByName)
                .collect(Collectors.toList());

        return catalogService.findFertilizersForCrops(crops);
    }
}
