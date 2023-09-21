package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.QuestDTO;
import com.bachelor.nexa.entities.Difficulty;
import com.bachelor.nexa.entities.Quest;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.mappers.QuestStructMapper;
import com.bachelor.nexa.repositories.DifficultyRepository;
import com.bachelor.nexa.repositories.QuestRepository;
import com.bachelor.nexa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestServiceImpl implements IQuestService{
    private final QuestRepository questRepository;
    private final UserRepository userRepository;
    private final DifficultyRepository difficultyRepository;
    @Override
    public List<QuestDTO> findAllByUserId(Long userId) {
        List<Quest> quests =  questRepository.findAllByUserId(userId);
        return quests.stream().map(QuestStructMapper::questToQuestDto).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public QuestDTO createNewQuest(QuestDTO request, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Difficulty> difficultyOptional = difficultyRepository.findById(request.getDifficulty().getId());
        if(userOptional.isPresent() && difficultyOptional.isPresent()){
            User user = userOptional.get();
            Difficulty difficulty = difficultyOptional.get();

            Quest questToSave = new Quest();
            questToSave.setTitle(request.getTitle());
            questToSave.setUser(user);
            questToSave.setDifficulty(difficulty);
            questToSave.setCreatedAt(LocalDateTime.now());
            questToSave.setStatus(false);

            questRepository.save(questToSave);
            return QuestStructMapper.questToQuestDto(questToSave);
        } else {
            throw new Exception("User or Difficulty not found!");
        }
    }

    @SneakyThrows
    @Override
    public QuestDTO deleteByQuestId(Long questId) {
        Optional<Quest> questOptional = questRepository.findById(questId);
        if(questOptional.isPresent()){
            Quest questToDelete = questOptional.get();
            questRepository.delete(questToDelete);
            return QuestStructMapper.questToQuestDto(questToDelete);
        } else {
            throw new Exception("Quest not found!");
        }
    }
}
