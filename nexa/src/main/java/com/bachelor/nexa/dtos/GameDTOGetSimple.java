package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Difficulty;
import com.bachelor.nexa.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTOGetSimple {
    private Long id;
    private String title;
    private String description;
    private Difficulty difficulty;
    private List<QuestionDTO> questionDTOList;

    public GameDTOGetSimple(Game game){
        this.id = game.getId();
        this.title = game.getTitle();
        this.description = game.getDescription();
        this.difficulty = game.getDifficulty();
    }
}
