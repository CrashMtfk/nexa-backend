package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private Long id;
    private String answerText;
    private boolean isCorrect;

    public AnswerDTO(Answer answer){
        this.id = answer.getId();
        this.answerText = answer.getAnswerText();
        this.isCorrect = answer.isCorrect();
    }
}
