// // // package com.example.demo.service.impl;

// // // import com.example.demo.entity.Crop;
// // // import com.example.demo.entity.Fertilizer;
// // // import com.example.demo.repository.CropRepository;
// // // import com.example.demo.repository.FertilizerRepository;
// // // import com.example.demo.service.CatalogService;
// // // import lombok.RequiredArgsConstructor;
// // // import org.springframework.stereotype.Service;

// // // import java.util.ArrayList;
// // // import java.util.List;

// // // @Service
// // // @RequiredArgsConstructor
// // // public class CatalogServiceImpl implements CatalogService {

// // //     private final CropRepository cropRepository;
// // //     private final FertilizerRepository fertilizerRepository;

// // //     @Override
// // //     public Crop addCrop(Crop crop) {
// // //         return cropRepository.save(crop);
// // //     }

// // //     @Override
// // //     public Fertilizer addFertilizer(Fertilizer fertilizer) {
// // //         return fertilizerRepository.save(fertilizer);
// // //     }

// // //     @Override
// // //     public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
// // //         return cropRepository.findSuitableCrops(ph, waterLevel, season);
// // //     }

// // //     @Override
// // //     public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
// // //         List<Fertilizer> result = new ArrayList<>();
// // //         for (String crop : cropNames) {
// // //             result.addAll(
// // //                     fertilizerRepository.findByRecommendedForCropsContaining(crop)
// // //             );
// // //         }
// // //         return result;
// // //     }
// // // }


// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Crop;
// // import com.example.demo.entity.Fertilizer;
// // import com.example.demo.repository.CropRepository;
// // import com.example.demo.repository.FertilizerRepository;
// // import com.example.demo.service.CatalogService;
// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class CatalogServiceImpl implements CatalogService {

// //     private final CropRepository cropRepository;
// //     private final FertilizerRepository fertilizerRepository;

// //     public CatalogServiceImpl(CropRepository cropRepository,
// //                               FertilizerRepository fertilizerRepository) {
// //         this.cropRepository = cropRepository;
// //         this.fertilizerRepository = fertilizerRepository;
// //     }

// //     @Override
// //     public Crop addCrop(Crop crop) {
// //         return cropRepository.save(crop);
// //     }

// //     @Override
// //     public Fertilizer addFertilizer(Fertilizer fertilizer) {
// //         return fertilizerRepository.save(fertilizer);
// //     }

// //     @Override
// //     public List<Fertilizer> getAllFertilizers() {
// //         return fertilizerRepository.findAll();
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
// import java.util.stream.Collectors;

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
//     public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
//         return cropRepository.findAll()
//                 .stream()
//                 .filter(c -> ph >= c.getSuitablePHMin() &&
//                              ph <= c.getSuitablePHMax() &&
//                              water >= c.getWaterLevelMin() &&
//                              water <= c.getWaterLevelMax() &&
//                              c.getSuitableSeason().equalsIgnoreCase(season))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
//         return fertilizerRepository.findAll()
//                 .stream()
//                 .filter(f -> cropNames.stream()
//                         .anyMatch(name -> f.getRecommendedForCrops().contains(name)))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public List<Crop> getAllCrops() {
//         return cropRepository.findAll();
//     }

//     @Override
//     public List<Fertilizer> getAllFertilizers() {
//         return fertilizerRepository.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax())
            throw new BadRequestException("PH min cannot be greater than PH max");
        if (!ValidationUtil.validSeason(crop.getSeason()))
            throw new BadRequestException("Invalid season");
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        if (!ValidationUtil.validNPK(fertilizer.getNpkRatio()))
            throw new BadRequestException("Invalid NPK format");
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
        return cropRepository.findBySuitablePHMinLessThanEqualAndSuitablePHMaxGreaterThanEqualAndRequiredWaterLessThanEqualAndSeason(
                ph, ph, waterLevel, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        List<Fertilizer> all = fertilizerRepository.findAll();
        return all.stream()
                .filter(f -> Arrays.stream(f.getRecommendedForCrops().split(","))
                        .anyMatch(cropNames::contains))
                .collect(Collectors.toList());
    }
}

