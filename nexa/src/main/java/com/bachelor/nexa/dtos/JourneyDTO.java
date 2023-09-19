package com.bachelor.nexa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDTO {
    private Long id;
    private String title;
    private int coins;
    private int experience;
    private List<StageDTO> stageDTOSet;
}
