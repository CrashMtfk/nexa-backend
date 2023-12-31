package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.AdventureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureNotesRepository extends JpaRepository<AdventureNote,Long> {
    List<AdventureNote> findAllByUser_Id(Long userId);
}
