package com.bachelor.nexa.mappers;

import com.bachelor.nexa.dtos.UserDTO;
import com.bachelor.nexa.entities.User;

public class UserStructMapper {
    public static UserDTO userToUserDto(User user){
        if(user == null){
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPlayerName(user.getPlayerName());
        userDTO.setLevel(user.getLevel());
        userDTO.setCoins(user.getCoins());
        userDTO.setExperience(user.getExperience());
        userDTO.setRequiredExperience(user.getRequiredExperience());

        return userDTO;
    }
}
