// package com.example.demo.repository;

// import com.example.demo.entity.Crop;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import java.util.List;

// public interface CropRepository extends JpaRepository<Crop, Long> {

//     @Query("""
//         SELECT c FROM Crop c
//         WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax
//           AND c.requiredWater <= :water
//           AND c.season = :season
//     """)
//     List<Crop> findSuitableCrops(
//             @Param("ph") Double ph,
//             @Param("water") Double water,
//             @Param("season") String season
//     );
// }

package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findBySuitablePHMinLessThanEqualAndSuitablePHMaxGreaterThanEqualAndRequiredWaterLessThanEqualAndSeason(
            Double phMin, Double phMax, Double water, String season);
}

