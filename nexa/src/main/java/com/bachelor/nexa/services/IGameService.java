package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.GameDTO;

import java.util.List;

public interface IGameService {
    GameDTO findGameById(Long id);
    List<GameDTO> findAllGames();
}
