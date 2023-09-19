package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.JourneyDTO;
import com.bachelor.nexa.dtos.StageDTO;
import com.bachelor.nexa.entities.Journey;
import com.bachelor.nexa.entities.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JourneyStructMapper {
    public static JourneyDTO journeyToJourneyDTO(Journey journey){
        if(journey == null){
            return null;
        }

        JourneyDTO journeyDTO = new JourneyDTO();
        journeyDTO.setId(journey.getId());
        journeyDTO.setTitle(journey.getTitle());
        journeyDTO.setCoins(journey.getCoins());
        journeyDTO.setExperience(journey.getExperience());

        List<StageDTO> stageDTOSet = new ArrayList<>();
        for (Stage stage: journey.getStageSet()) {
            StageDTO stageDTO = new StageDTO(stage);
            stageDTOSet.add(stageDTO);
        }
        journeyDTO.setStageDTOSet(stageDTOSet);

        return journeyDTO;
    }
}
