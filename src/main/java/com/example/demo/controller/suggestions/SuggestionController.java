// package com.example.demo.controller;

// import com.example.demo.service.SuggestionService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/suggestions")
// @RequiredArgsConstructor
// public class SuggestionController {

//     private final SuggestionService suggestionService;

//     @PostMapping("/{farmId}")
//     public ResponseEntity<?> generateSuggestion(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.generateSuggestion(farmId)
//         );
//     }

//     @GetMapping("/{suggestionId}")
//     public ResponseEntity<?> getSuggestion(@PathVariable Long suggestionId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestion(suggestionId)
//         );
//     }

//     @GetMapping("/farm/{farmId}")
//     public ResponseEntity<?> getSuggestionsByFarm(@PathVariable Long farmId) {
//         return ResponseEntity.ok(
//                 suggestionService.getSuggestionsByFarm(farmId)
//         );
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/{farmId}")
    public Suggestion generateSuggestion(@PathVariable Long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    @GetMapping("/{suggestionId}")
    public Suggestion getSuggestion(@PathVariable Long suggestionId) {
        return suggestionService.getSuggestion(suggestionId);
    }

    @GetMapping("/farm/{farmId}")
    public List<Suggestion> getSuggestionsByFarm(@PathVariable Long farmId) {
        return suggestionService.getSuggestionsByFarm(farmId);
    }
}
