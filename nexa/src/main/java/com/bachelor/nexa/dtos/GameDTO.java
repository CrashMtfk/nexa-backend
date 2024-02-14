package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;
    private String title;
    private String description;
    private Difficulty difficulty;
    private List<QuestionDTO> questionDTOList;
}
