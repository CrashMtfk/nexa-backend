package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.JourneyDTO;
import com.bachelor.nexa.entities.Journey;
import com.bachelor.nexa.mappers.JourneyStructMapper;
import com.bachelor.nexa.repositories.JourneyRepository;
import com.bachelor.nexa.repositories.StageRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@Service
public class JourneyServiceImpl implements IJourneyService{
    private final JourneyRepository journeyRepository;
    private final StageRepository stageRepository;
    @Override
    public List<JourneyDTO> findAllByUserId(Long userId) {
        List<Journey> journeys = journeyRepository.findAllByUserId(userId);
        return journeys.stream().map(JourneyStructMapper::journeyToJourneyDTO).collect(Collectors.toList());
    }
}
