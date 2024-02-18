package com.bachelor.nexa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTOGetAll {
    private Long id;
    private String title;
    private String description;
}
