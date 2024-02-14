package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.AnswerDTO;
import com.bachelor.nexa.dtos.GameDTO;
import com.bachelor.nexa.dtos.QuestionDTO;
import com.bachelor.nexa.entities.Answer;
import com.bachelor.nexa.entities.Game;
import com.bachelor.nexa.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class GameStructMapper {
    public static GameDTO gameToGameDTO(Game game){
        if (game == null){
            return null;
        }

        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setTitle(game.getTitle());
        gameDTO.setDescription(game.getDescription());
        gameDTO.setDifficulty(game.getDifficulty());
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question: game.getQuestionList()) {
            QuestionDTO questionDTO = new QuestionDTO(question);
            List<AnswerDTO> answerDTOList = new ArrayList<>();
            for (Answer answer : question.getAnswerList()) {
                AnswerDTO answerDTO = new AnswerDTO(answer);
                answerDTOList.add(answerDTO);
            }
            questionDTO.setAnswerList(answerDTOList);
            questionDTOList.add(questionDTO);
        }
        gameDTO.setQuestionDTOList(questionDTOList);
        return gameDTO;
    }
}
