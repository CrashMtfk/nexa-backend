package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.JourneyDTO;
import com.bachelor.nexa.dtos.StageDTO;
import com.bachelor.nexa.entities.Journey;
import com.bachelor.nexa.entities.Stage;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.mappers.JourneyStructMapper;
import com.bachelor.nexa.repositories.JourneyRepository;
import com.bachelor.nexa.repositories.StageRepository;
import com.bachelor.nexa.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@Service
public class JourneyServiceImpl implements IJourneyService{
    private final JourneyRepository journeyRepository;
    private final StageRepository stageRepository;
    private final UserRepository userRepository;
    @Override
    public List<JourneyDTO> findAllByUserId(Long userId) {
        List<Journey> journeys = journeyRepository.findAllByUserId(userId);
        return journeys.stream().map(JourneyStructMapper::journeyToJourneyDTO).collect(Collectors.toList());
    }

    @Override
    public JourneyDTO createJourney(JourneyDTO request, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Journey journey = new Journey();
            journey.setTitle(request.getTitle());
            journey.setUser(user);
            journey.setCoins(request.getCoins());
            journey.setExperience(request.getExperience());
            journeyRepository.save(journey);
            List<Stage> stages = new ArrayList<>();
            for (StageDTO stage : request.getStageDTOSet()) {
                Stage journeyStage = new Stage();
                journeyStage.setJourney(journey);
                journeyStage.setTitle(stage.getTitle());
                journeyStage.setDescription(stage.getDescription());
                journeyStage.setStatus(false);
                stages.add(journeyStage);
                stageRepository.save(journeyStage);
            }
            journey.setStageSet(stages);
            return JourneyStructMapper.journeyToJourneyDTO(journey);
        }
        return null;
    }

    @Override
    public JourneyDTO updateJourney(JourneyDTO request) {
        Optional<Journey> journeyOptional = journeyRepository.findById(request.getId());
        if(journeyOptional.isPresent()){
            Journey journeyToUpdate = journeyOptional.get();
            journeyToUpdate.setTitle(request.getTitle());
            journeyRepository.save(journeyToUpdate);
            for (StageDTO stage: request.getStageDTOSet()) {
                Optional<Stage> stageOptional = stageRepository.findById(stage.getId());
                if (stageOptional.isPresent()){
                    Stage stageToUpdate = stageOptional.get();
                    stageToUpdate.setTitle(stage.getTitle());
                    stageToUpdate.setDescription(stage.getDescription());
                    stageRepository.save(stageToUpdate);
                }
            }
            return JourneyStructMapper.journeyToJourneyDTO(journeyToUpdate);
        }
        return null;
    }

    @Override
    public JourneyDTO deleteJourney(Long journeyId){
        Optional<Journey> journeyOptional = journeyRepository.findById(journeyId);
        if (journeyOptional.isPresent()){
            Journey journeyToDelete = journeyOptional.get();
            List<Stage> journeyStages = journeyToDelete.getStageSet();
            stageRepository.deleteAll(journeyStages);
            journeyRepository.delete(journeyToDelete);
            return JourneyStructMapper.journeyToJourneyDTO(journeyToDelete);
        }
        return null;
    }


}
