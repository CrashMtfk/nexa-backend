package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface StageRepository extends JpaRepository<Stage,Long> {
    Set<Stage> findAllByJourney_Id(Long journeyId);
}
