package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public Crop addCrop(@RequestBody Crop crop) {
        return catalogService.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody Fertilizer fertilizer) {
        return catalogService.addFertilizer(fertilizer);
    }

    @GetMapping("/crops/suitable")
    public List<Crop> getSuitableCrops(@RequestParam Double ph,
                                       @RequestParam Double waterLevel,
                                       @RequestParam String season) {
        return catalogService.findSuitableCrops(ph, waterLevel, season);
    }

    @PostMapping("/fertilizers")
    public List<Fertilizer> getFertilizersForCrops(@RequestBody List<String> cropNames) {
        return catalogService.findFertilizersForCrops(cropNames);
    }
}
