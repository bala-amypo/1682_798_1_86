import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    Optional<Crop> findByName(String name);
    List<Crop> findBySuitablePHMinLessThanEqualAndSuitablePHMaxGreaterThanEqualAndSeason(Double minPH, Double maxPH, String season);
}
