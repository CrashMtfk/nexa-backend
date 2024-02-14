package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.AdventureNotesDTO;
import com.bachelor.nexa.entities.AdventureNote;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.mappers.AdventureNotesStructMapper;
import com.bachelor.nexa.repositories.AdventureNotesRepository;
import com.bachelor.nexa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdventureNotesServiceImpl implements IAdventureNotesService {
    private final AdventureNotesRepository adventureNotesRepository;
    private final UserRepository userRepository;

    @Override
    public List<AdventureNotesDTO> findAllByUserId(Long id) {
        return adventureNotesRepository.findAllByUser_Id(id)
                .stream().map(AdventureNotesStructMapper::adventureNoteToAdventureNoteShowDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public AdventureNotesDTO saveNewNote(AdventureNotesDTO adventureNotesDTO, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            AdventureNote noteToSave = new AdventureNote();

            noteToSave.setUser(user);
            noteToSave.setTitle(adventureNotesDTO.getTitle());
            noteToSave.setCreatedAt(LocalDateTime.now());
            noteToSave.setAccomplishment(adventureNotesDTO.getAccomplishment());
            noteToSave.setImprovement(adventureNotesDTO.getImprovement());
            noteToSave.setThought(adventureNotesDTO.getThought());

            adventureNotesRepository.save(noteToSave);

            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToSave);
        } else {
            throw new Exception("Adventure note not found!");
        }
    }

    @SneakyThrows
    @Override
    public AdventureNotesDTO deleteNote(Long noteId) {
        Optional<AdventureNote> noteOptional = adventureNotesRepository.findById(noteId);
        if(noteOptional.isPresent()){
            AdventureNote noteToDelete = noteOptional.get();
            adventureNotesRepository.delete(noteToDelete);
            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToDelete);
        } else {
            throw new Exception("Adventure note not found!");
        }
    }

    @SneakyThrows
    @Override
    public AdventureNotesDTO updateNote(AdventureNotesDTO receivedNote) {
        Optional<AdventureNote> notesOptional = adventureNotesRepository.findById(receivedNote.getId());
        if(notesOptional.isPresent()){
            AdventureNote noteToUpdate = notesOptional.get();

            noteToUpdate.setTitle(receivedNote.getTitle());
            noteToUpdate.setAccomplishment(receivedNote.getAccomplishment());
            noteToUpdate.setImprovement(receivedNote.getImprovement());
            noteToUpdate.setThought(receivedNote.getThought());

            adventureNotesRepository.save(noteToUpdate);

            return AdventureNotesStructMapper.adventureNoteToAdventureNoteShowDto(noteToUpdate);
        } else {
            throw new Exception("Adventure note not found!");
        }
    }
}
