package com.bachelor.nexa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdventureNotesDTO {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String accomplishment;
    private String improvement;
    private String thought;
}
