package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.AdventureNotesDTO;

import java.util.List;

public interface IAdventureNotesService {
    List<AdventureNotesDTO> findAllByUserId(Long id);
    AdventureNotesDTO saveNewNote(AdventureNotesDTO adventureNotesDTO, Long userId);
    AdventureNotesDTO deleteNote(Long noteId);
    AdventureNotesDTO updateNote(AdventureNotesDTO adventureNotesDTO);
}
