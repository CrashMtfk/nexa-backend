package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.GameDTOGetAll;
import com.bachelor.nexa.dtos.GameDTOGetSimple;
import com.bachelor.nexa.services.GameServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@Data
@RequiredArgsConstructor
@RestController
public class GameController {
    private final GameServiceImpl gameService;

    @GetMapping("/games")
    public ResponseEntity<List<GameDTOGetAll>> findAllGames(){
        return ResponseEntity.ok(gameService.findAllGames());
    }
    @GetMapping("/games/{gameId}")
    public ResponseEntity<GameDTOGetSimple> findByGameId(@PathVariable Long gameId){
        return ResponseEntity.ok(gameService.findGameById(gameId));
    }

}
