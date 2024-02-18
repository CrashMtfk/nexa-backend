package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.AnswerDTO;
import com.bachelor.nexa.dtos.GameDTOGetAll;
import com.bachelor.nexa.dtos.GameDTOGetSimple;
import com.bachelor.nexa.dtos.QuestionDTO;
import com.bachelor.nexa.entities.Answer;
import com.bachelor.nexa.entities.Game;
import com.bachelor.nexa.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class GameStructMapper {
    public static GameDTOGetSimple gameToGameDTOGetSimple(Game game){
        if (game == null){
            return null;
        }

        GameDTOGetSimple gameDTOGetSimple = new GameDTOGetSimple();
        gameDTOGetSimple.setId(game.getId());
        gameDTOGetSimple.setTitle(game.getTitle());
        gameDTOGetSimple.setDescription(game.getDescription());
        gameDTOGetSimple.setDifficulty(game.getDifficulty());
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
        gameDTOGetSimple.setQuestionDTOList(questionDTOList);
        return gameDTOGetSimple;
    }

    public static GameDTOGetAll gameToGameDTOGetAll(Game game){
        if (game == null){
            return null;
        }

        GameDTOGetAll gameDTOGetAll = new GameDTOGetAll();
        gameDTOGetAll.setId(game.getId());
        gameDTOGetAll.setTitle(game.getTitle());
        gameDTOGetAll.setDescription(game.getDescription());
        return gameDTOGetAll;
    }
}
