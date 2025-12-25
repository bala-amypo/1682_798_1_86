package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CropRepository extends JpaRepository<Crop, Long> {
    // Make sure the Crop entity has a field `name`
    Optional<Crop> findByName(String name);
}
