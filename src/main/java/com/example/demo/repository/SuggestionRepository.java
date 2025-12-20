package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    List<Suggestion> findByFarmId(Long farmId);
}
