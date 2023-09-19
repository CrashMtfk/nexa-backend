package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty,Long> {
}
