package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.AdventureNotesDTO;
import com.bachelor.nexa.entities.AdventureNotes;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.mappers.AdventureNotesStructMapper;
import com.bachelor.nexa.repositories.AdventureNotesRepository;
import com.bachelor.nexa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdventureNotesServiceImpl implements IAdventureNotesService {
    private final AdventureNotesRepository adventureNotesRepository;
    private final UserRepository userRepository;

    public AdventureNotesServiceImpl(AdventureNotesRepository adventureNotesRepository, UserRepository userRepository) {
        this.adventureNotesRepository = adventureNotesRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AdventureNotesDTO> findAllByUserId(Long id) {
        List<AdventureNotes> adventureNotes = adventureNotesRepository.findAllByUser_Id(id);
        return adventureNotes.stream().map(AdventureNotesStructMapper::adventureNoteToAdventureNoteShowDto).collect(Collectors.toList());
    }

    @Override
    public AdventureNotesDTO saveNewNote(AdventureNotesDTO adventureNotesDTO, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            AdventureNotes noteToSave = new AdventureNotes();

            noteToSave.setUser(user);
            noteToSave.setTitle(adventureNotesDTO.getTitle());
            noteToSave.setCreatedAt(LocalDateTime.now());
            noteToSave.setAccomplishment(adventureNotesDTO.getAccomplishment());
            noteToSave.setImprovement(adventureNotesDTO.getImprovement());
            noteToSave.setThought(adventureNotesDTO.getThought());

            adventureNotesRepository.save(noteToSave);

            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToSave);
        }

        return null;
    }

    @Override
    public AdventureNotesDTO deleteNote(Long noteId) {
        Optional<AdventureNotes> noteOptional = adventureNotesRepository.findById(noteId);
        if(noteOptional.isPresent()){
            AdventureNotes noteToDelete = noteOptional.get();
            adventureNotesRepository.delete(noteToDelete);
            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToDelete);
        }
        return null;
    }

    @Override
    public AdventureNotesDTO updateNote(AdventureNotesDTO receivedNote) {
        Optional<AdventureNotes> notesOptional = adventureNotesRepository.findById(receivedNote.getId());
        if(notesOptional.isPresent()){
            AdventureNotes noteToUpdate = notesOptional.get();

            noteToUpdate.setTitle(receivedNote.getTitle());
            noteToUpdate.setAccomplishment(receivedNote.getAccomplishment());
            noteToUpdate.setImprovement(receivedNote.getImprovement());
            noteToUpdate.setThought(receivedNote.getThought());

            adventureNotesRepository.save(noteToUpdate);

            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToUpdate);
        }

        return null;
    }
}