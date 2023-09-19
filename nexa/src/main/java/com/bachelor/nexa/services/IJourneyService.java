package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.JourneyDTO;

import java.util.List;

public interface IJourneyService {
    List<JourneyDTO> findAllByUserId(Long userId);
}
