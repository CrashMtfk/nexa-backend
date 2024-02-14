package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Game;
import com.bachelor.nexa.entities.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageDTO {
    private Long id;
    private Game game;
    private boolean status;

    public StageDTO(Stage stage){
        this.id = stage.getId();
        this.status = stage.isStatus();
        this.game = stage.getGame();
    }
}
