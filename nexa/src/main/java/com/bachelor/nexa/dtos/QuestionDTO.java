package com.bachelor.nexa.dtos;

import com.bachelor.nexa.entities.Answer;
import com.bachelor.nexa.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String questionText;
    private List<AnswerDTO> answerList;

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.questionText = question.getQuestionText();
    }
}
