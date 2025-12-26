package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // Finds crops suitable for a given pH and season
    @Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph AND c.season = :season")
    List<Crop> findSuitableCrops(@Param("ph") Double ph, @Param("season") String season);
}
