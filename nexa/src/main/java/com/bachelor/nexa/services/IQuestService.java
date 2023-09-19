package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.QuestDTO;

import java.util.List;

public interface IQuestService {
    List<QuestDTO> findAllByUserId(Long userId);
    QuestDTO createNewQuest(QuestDTO quest, Long userId);
    QuestDTO deleteByQuestId(Long questId);
}
