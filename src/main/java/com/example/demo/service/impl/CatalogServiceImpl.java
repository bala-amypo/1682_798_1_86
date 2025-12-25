@Override
public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
    if (cropNames.isEmpty()) {
        return List.of();
    }

    return fertilizerRepository.findAll().stream()
            .filter(f -> f.getCrop() != null && cropNames.contains(f.getCrop().getName()))
            .distinct()
            .collect(Collectors.toList());
}

@Override
public Crop findCropByName(String name) {
    return cropRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("Crop not found: " + name));
}
