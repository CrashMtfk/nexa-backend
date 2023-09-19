package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.JourneyDTO;
import com.bachelor.nexa.entities.Journey;
import com.bachelor.nexa.services.JourneyServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
public class JourneyController {
    private final JourneyServiceImpl journeyService;

    @GetMapping("/user/journeys/{userId}")
    public ResponseEntity<List<JourneyDTO>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(journeyService.findAllByUserId(userId));
    }
}
