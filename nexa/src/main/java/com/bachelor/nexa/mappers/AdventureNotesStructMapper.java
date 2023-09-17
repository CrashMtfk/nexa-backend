package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.AdventureNotesDTO;
import com.bachelor.nexa.entities.AdventureNotes;

public class AdventureNotesStructMapper {
    public static AdventureNotesDTO adventureNoteToAdventureNoteShowDto(AdventureNotes adventureNote){
        if(adventureNote == null){
            return null;
        }

        AdventureNotesDTO adventureNoteDto = new AdventureNotesDTO();
        adventureNoteDto.setId(adventureNote.getId());
        adventureNoteDto.setTitle(adventureNote.getTitle());
        adventureNoteDto.setCreatedAt(adventureNote.getCreatedAt());
        adventureNoteDto.setAccomplishment(adventureNote.getAccomplishment());
        adventureNoteDto.setImprovement(adventureNote.getImprovement());
        adventureNoteDto.setThought(adventureNote.getThought());

        return adventureNoteDto;
    }
}
