package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageDTO {
    private Long id;
    private String title;
    private String description;
    private boolean status;

    public StageDTO(Stage stage){
        this.id = stage.getId();
        this.title = stage.getTitle();
        this.description = stage.getDescription();
        this.status = stage.isStatus();
    }
}
