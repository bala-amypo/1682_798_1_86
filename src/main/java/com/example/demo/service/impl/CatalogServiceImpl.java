// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Crop;
// // import com.example.demo.entity.Fertilizer;
// // import com.example.demo.repository.CropRepository;
// // import com.example.demo.repository.FertilizerRepository;
// // import com.example.demo.service.CatalogService;
// // import lombok.RequiredArgsConstructor;
// // import org.springframework.stereotype.Service;

// // import java.util.ArrayList;
// // import java.util.List;

// // @Service
// // @RequiredArgsConstructor
// // public class CatalogServiceImpl implements CatalogService {

// //     private final CropRepository cropRepository;
// //     private final FertilizerRepository fertilizerRepository;

// //     @Override
// //     public Crop addCrop(Crop crop) {
// //         return cropRepository.save(crop);
// //     }

// //     @Override
// //     public Fertilizer addFertilizer(Fertilizer fertilizer) {
// //         return fertilizerRepository.save(fertilizer);
// //     }

// //     @Override
// //     public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
// //         return cropRepository.findSuitableCrops(ph, waterLevel, season);
// //     }

// //     @Override
// //     public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
// //         List<Fertilizer> result = new ArrayList<>();
// //         for (String crop : cropNames) {
// //             result.addAll(
// //                     fertilizerRepository.findByRecommendedForCropsContaining(crop)
// //             );
// //         }
// //         return result;
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.entity.Crop;
// import com.example.demo.entity.Fertilizer;
// import com.example.demo.repository.CropRepository;
// import com.example.demo.repository.FertilizerRepository;
// import com.example.demo.service.CatalogService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CatalogServiceImpl implements CatalogService {

//     private final CropRepository cropRepository;
//     private final FertilizerRepository fertilizerRepository;

//     public CatalogServiceImpl(CropRepository cropRepository,
//                               FertilizerRepository fertilizerRepository) {
//         this.cropRepository = cropRepository;
//         this.fertilizerRepository = fertilizerRepository;
//     }

//     @Override
//     public Crop addCrop(Crop crop) {
//         return cropRepository.save(crop);
//     }

//     @Override
//     public Fertilizer addFertilizer(Fertilizer fertilizer) {
//         return fertilizerRepository.save(fertilizer);
//     }

//     @Override
//     public List<Fertilizer> getAllFertilizers() {
//         return fertilizerRepository.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        // Filter crops that match the soil pH, water level, and season
        return cropRepository.findAll()
                .stream()
                .filter(crop -> ph >= crop.getSuitablePHMin() &&
                                ph <= crop.getSuitablePHMax() &&
                                water >= crop.getWaterLevelMin() &&
                                water <= crop.getWaterLevelMax() &&
                                crop.getSuitableSeason().equalsIgnoreCase(season))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        // Filter fertilizers whose recommended crops match the given list
        return fertilizerRepository.findAll()
                .stream()
                .filter(f -> cropNames.stream()
                        .anyMatch(name -> f.getRecommendedForCrops().contains(name)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }
}
