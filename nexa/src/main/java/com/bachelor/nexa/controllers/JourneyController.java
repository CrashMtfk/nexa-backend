package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.JourneyDTO;
import com.bachelor.nexa.services.JourneyServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@Data
@RequiredArgsConstructor
@RestController
public class JourneyController {
    private final JourneyServiceImpl journeyService;

    @GetMapping("/user/journeys/{userId}")
    public ResponseEntity<List<JourneyDTO>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(journeyService.findAllByUserId(userId));
    }

    @PostMapping("/user/journey/{userId}")
    public ResponseEntity<JourneyDTO> createNewJourney(
            @PathVariable Long userId,
            @RequestBody JourneyDTO request
    ){
        return ResponseEntity.ok(journeyService.createJourney(request, userId));
    }

    @PatchMapping("/user/journey")
    public ResponseEntity<JourneyDTO> updateJourney(@RequestBody JourneyDTO request){
        return ResponseEntity.ok(journeyService.updateJourney(request));
    }

    @DeleteMapping("/user/journey/{journeyId}")
    public ResponseEntity<JourneyDTO> deleteJourney(@PathVariable Long journeyId) {
        return ResponseEntity.ok(journeyService.deleteJourney(journeyId));
    }

}
