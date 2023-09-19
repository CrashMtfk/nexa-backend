package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Long> {
    List<Quest> findAllByUserId(Long userId);
}
