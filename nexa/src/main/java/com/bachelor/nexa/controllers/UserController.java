package com.bachelor.nexa.controllers;

import com.bachelor.nexa.dtos.UserDTO;
import com.bachelor.nexa.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping("/users/leaderboard")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getLeaderboard());
    }
    @PatchMapping("/user/{userId}")
    public ResponseEntity<UserDTO> levelUp(@PathVariable Long userId){
        return ResponseEntity.ok(userService.levelUp(userId));
    }
    @PatchMapping("/user/{userId}/{experience}")
    public ResponseEntity<UserDTO> changeExperience(
            @PathVariable Long userId,
            @PathVariable int experience
    ){
        return ResponseEntity.ok(userService.changeExperience(userId,experience));
    }
}
