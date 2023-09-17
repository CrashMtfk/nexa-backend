package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.AdventureNotesDTO;
import com.bachelor.nexa.services.AdventureNotesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdventureNotesController {
    private final AdventureNotesServiceImpl adventureNotesService;

    public AdventureNotesController(AdventureNotesServiceImpl adventureNotesService) {
        this.adventureNotesService = adventureNotesService;
    }

    @GetMapping("/{userId}/adventure_notes")
    public ResponseEntity<List<AdventureNotesDTO>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(adventureNotesService.findAllByUserId(userId));
    }

    @PostMapping("/{userId}/adventure_note")
    public ResponseEntity<AdventureNotesDTO> saveNewNote(
            @PathVariable Long userId,
            @RequestBody AdventureNotesDTO noteRequest
    ){
        return ResponseEntity.ok(adventureNotesService.saveNewNote(noteRequest,userId));
    }
    @DeleteMapping("/adventure_note/{noteId}")
    public ResponseEntity<AdventureNotesDTO> deleteNote(@PathVariable Long noteId){
        return ResponseEntity.ok(adventureNotesService.deleteNote(noteId));
    }

    @PatchMapping("/adventure_note")
    public ResponseEntity<AdventureNotesDTO> updateNote(@RequestBody AdventureNotesDTO request){
        return ResponseEntity.ok(adventureNotesService.updateNote(request));
    }
}