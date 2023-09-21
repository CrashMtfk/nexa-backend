package com.bachelor.nexa.services;

import com.bachelor.nexa.dtos.UserDTO;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.mappers.UserStructMapper;
import com.bachelor.nexa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    @Override
    public List<UserDTO> getLeaderboard() {
        List<User> users = userRepository.findAll();
        Collections.reverse(users);
        return users.stream().map(UserStructMapper::userToUserDto).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public UserDTO levelUp(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setLevel(user.getLevel() + 1);
            user.setExperience(0);
            user.setRequiredExperience(user.getLevel() * 100);

            userRepository.save(user);

            return UserStructMapper.userToUserDto(user);
        } else {
            throw new Exception("User not found!");
        }
    }

    @SneakyThrows
    @Override
    public UserDTO changeExperience(Long userId, int experience) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setExperience(user.getExperience() + experience);

            userRepository.save(user);

            return UserStructMapper.userToUserDto(user);
        } else {
            throw new Exception("User not found!");
        }
    }

}
