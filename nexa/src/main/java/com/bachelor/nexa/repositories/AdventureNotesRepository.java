package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.AdventureNotes;
import com.bachelor.nexa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureNotesRepository extends JpaRepository<AdventureNotes,Long> {
    List<AdventureNotes> findAllByUser_Id(Long userId);
}
