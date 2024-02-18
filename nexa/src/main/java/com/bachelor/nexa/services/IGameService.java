package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.GameDTOGetAll;
import com.bachelor.nexa.dtos.GameDTOGetSimple;

import java.util.List;

public interface IGameService {
    GameDTOGetSimple findGameById(Long id);
    List<GameDTOGetAll> findAllGames();
}
