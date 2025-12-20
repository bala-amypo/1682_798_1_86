// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Crop;
// // import com.example.demo.entity.Farm;
// // import com.example.demo.entity.Fertilizer;
// // import com.example.demo.entity.Suggestion;
// // import com.example.demo.exception.ResourceNotFoundException;
// // import com.example.demo.repository.FarmRepository;
// // import com.example.demo.repository.SuggestionRepository;
// // import com.example.demo.service.CatalogService;
// // import com.example.demo.service.SuggestionService;
// // import lombok.RequiredArgsConstructor;
// // import org.springframework.stereotype.Service;

// // import java.util.List;
// // import java.util.stream.Collectors;

// // @Service
// // @RequiredArgsConstructor
// // public class SuggestionServiceImpl implements SuggestionService {

// //     private final FarmRepository farmRepository;
// //     private final SuggestionRepository suggestionRepository;
// //     private final CatalogService catalogService;

// //     @Override
// //     public Suggestion generateSuggestion(Long farmId) {

// //         Farm farm = farmRepository.findById(farmId)
// //                 .orElseThrow(() -> new ResourceNotFoundException("Farm"));

// //         List<Crop> crops = catalogService.findSuitableCrops(
// //                 farm.getSoilPH(),
// //                 farm.getWaterLevel(),
// //                 farm.getSeason()
// //         );

// //         List<String> cropNames = crops.stream()
// //                 .map(Crop::getName)
// //                 .collect(Collectors.toList());

// //         List<Fertilizer> fertilizers =
// //                 catalogService.findFertilizersForCrops(cropNames);

// //         Suggestion suggestion = Suggestion.builder()
// //                 .farm(farm)
// //                 .suggestedCrops(String.join(",", cropNames))
// //                 .suggestedFertilizers(
// //                         fertilizers.stream()
// //                                 .map(Fertilizer::getName)
// //                                 .collect(Collectors.joining(","))
// //                 )
// //                 .build();

// //         return suggestionRepository.save(suggestion);
// //     }

// //     @Override
// //     public Suggestion getSuggestion(Long suggestionId) {
// //         return suggestionRepository.findById(suggestionId)
// //                 .orElseThrow(() -> new ResourceNotFoundException("Suggestion"));
// //     }

// //     @Override
// //     public List<Suggestion> getSuggestionsByFarm(Long farmId) {
// //         return suggestionRepository.findByFarmId(farmId);
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.CatalogService;
// import com.example.demo.service.SuggestionService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class SuggestionServiceImpl implements SuggestionService {

//     private final FarmRepository farmRepository;
//     private final SuggestionRepository suggestionRepository;
//     private final CatalogService catalogService;

//     public SuggestionServiceImpl(FarmRepository farmRepository,
//                                  SuggestionRepository suggestionRepository,
//                                  CatalogService catalogService) {
//         this.farmRepository = farmRepository;
//         this.suggestionRepository = suggestionRepository;
//         this.catalogService = catalogService;
//     }

//     @Override
//     public Suggestion generateSuggestion(Long farmId) {

//         Farm farm = farmRepository.findById(farmId).orElseThrow();

//         List<Crop> crops = catalogService.findSuitableCrops(
//                 farm.getSoilPH(),
//                 farm.getWaterLevel(),
//                 farm.getSeason()
//         );

//         List<String> cropNames = crops.stream()
//                 .map(Crop::getName)
//                 .toList();

//         List<Fertilizer> fertilizers =
//                 catalogService.findFertilizersForCrops(cropNames);

//         List<String> fertilizerNames = fertilizers.stream()
//                 .map(Fertilizer::getName)
//                 .toList();

//         Suggestion suggestion = new Suggestion();
//         suggestion.setFarm(farm);
//         suggestion.setSuggestedCrops(String.join(",", cropNames));
//         suggestion.setSuggestedFertilizers(String.join(",", fertilizerNames));
//         suggestion.setCreatedAt(LocalDateTime.now());

//         return suggestionRepository.save(suggestion);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        List<Crop> crops = catalogService.findSuitableCrops(farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());
        List<String> cropNames = crops.stream().map(Crop::getName).collect(Collectors.toList());
        String cropStr = String.join(",", cropNames);

        List<Fertilizer> fertilizers = catalogService.findFertilizersForCrops(cropNames);
        String fertStr = fertilizers.stream().map(Fertilizer::getName).collect(Collectors.joining(","));

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(cropStr)
                .suggestedFertilizers(fertStr)
                .build();

        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
