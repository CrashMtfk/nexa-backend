package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.AdventureNotesDTO;
import com.bachelor.nexa.services.AdventureNotesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class AdventureNotesController {
    private final AdventureNotesServiceImpl adventureNotesService;

    @GetMapping("/user/adventure_notes/{userId}")
    public ResponseEntity<List<AdventureNotesDTO>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(adventureNotesService.findAllByUserId(userId));
    }

    @PostMapping("/user/adventure_note/{userId}")
    public ResponseEntity<AdventureNotesDTO> saveNewNote(
            @PathVariable Long userId,
            @RequestBody AdventureNotesDTO noteRequest
    ){
        return ResponseEntity.ok(adventureNotesService.saveNewNote(noteRequest,userId));
    }
    @DeleteMapping("/user/adventure_note/{noteId}")
    public ResponseEntity<AdventureNotesDTO> deleteNote(@PathVariable Long noteId){
        return ResponseEntity.ok(adventureNotesService.deleteNote(noteId));
    }

    @PatchMapping("/user/adventure_note")
    public ResponseEntity<AdventureNotesDTO> updateNote(@RequestBody AdventureNotesDTO request){
        return ResponseEntity.ok(adventureNotesService.updateNote(request));
    }
}
