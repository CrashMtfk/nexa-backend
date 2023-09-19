package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestDTO {
    private Long id;
    private Difficulty difficulty;
    private String title;
    private LocalDateTime createdAt;
    private boolean status;
}
