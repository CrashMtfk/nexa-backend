package com.bachelor.nexa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String playerName;
    private String username;
    private String password;
}
