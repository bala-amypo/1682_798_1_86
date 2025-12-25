@RestController
@RequestMapping("/api/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping("/{farmId}")
    public ResponseEntity<SuggestionResponseDTO> generate(
            @PathVariable Long farmId,
            @RequestBody SuggestionRequest request) {

        return ResponseEntity.ok(
                suggestionService.generateSuggestion(farmId, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuggestionResponseDTO> getSuggestion(@PathVariable Long id) {
        return ResponseEntity.ok(
                suggestionService.getSuggestion(id)
        );
    }
}
