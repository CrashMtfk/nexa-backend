package com.bachelor.nexa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String playerName;
    private int level;
    private int coins;
    private int experience;
    private int requiredExperience;
}
