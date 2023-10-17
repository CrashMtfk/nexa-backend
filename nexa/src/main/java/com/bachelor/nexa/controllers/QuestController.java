package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.QuestDTO;
import com.bachelor.nexa.services.QuestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class QuestController {
    private final QuestServiceImpl questService;

    @GetMapping("/user/quests/{userId}")
    public ResponseEntity<List<QuestDTO>> findAllQuestsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(questService.findAllByUserId(userId));
    }

    @PostMapping("/user/quest/{userId}")
    public ResponseEntity<QuestDTO> createNewQuest(
            @PathVariable Long userId,
            @RequestBody QuestDTO request
    ){
        return ResponseEntity.ok(questService.createNewQuest(request, userId));
    }

    @DeleteMapping("/user/quest/{questId}")
    public ResponseEntity<QuestDTO> deleteQuest(@PathVariable Long questId){
        return ResponseEntity.ok(questService.deleteByQuestId(questId));
    }
}
