package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.QuestDTO;
import com.bachelor.nexa.entities.Quest;

public class QuestStructMapper {
    public static QuestDTO questToQuestDto(Quest quest){
        if (quest == null) return null;

        QuestDTO questDTO = new QuestDTO();
        questDTO.setId(quest.getId());
        questDTO.setTitle(quest.getTitle());
        questDTO.setDifficulty(quest.getDifficulty());
        questDTO.setCreatedAt(quest.getCreatedAt());
        questDTO.setStatus(quest.isStatus());

        return questDTO;
    }
}
