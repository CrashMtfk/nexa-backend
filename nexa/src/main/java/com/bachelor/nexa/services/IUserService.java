package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.UserDTO;
import com.bachelor.nexa.entities.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> getLeaderboard();
    UserDTO levelUp(Long userId);
    UserDTO changeExperience(Long userId, int experience);

    UserDTO findUserById(Long userId);
}
