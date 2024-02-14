package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.GameDTO;
import com.bachelor.nexa.entities.Game;
import com.bachelor.nexa.mappers.GameStructMapper;
import com.bachelor.nexa.repositories.GameRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@Service
public class GameServiceImpl implements IGameService{
    private final GameRepository gameRepository;
    @Override
    public GameDTO findGameById(Long id) {
        Optional<Game> foundGame = gameRepository.findById(id);
        if (foundGame.isPresent()){
            Game game = foundGame.get();
            return GameStructMapper.gameToGameDTO(game);
        }
        return null;
    }

    @Override
    public List<GameDTO> findAllGames() {
        return gameRepository.findAll().stream().map(GameStructMapper::gameToGameDTO).collect(Collectors.toList());
    }
}
