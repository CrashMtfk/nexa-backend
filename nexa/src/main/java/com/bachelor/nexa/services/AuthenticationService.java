package com.bachelor.nexa.services;

import com.bachelor.nexa.config.JwtService;
import com.bachelor.nexa.dtos.AuthenticationRequest;
import com.bachelor.nexa.dtos.AuthenticationResponse;
import com.bachelor.nexa.dtos.RegisterRequest;
import com.bachelor.nexa.entities.User;
import com.bachelor.nexa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if(checkForExistingUser(request.getUsername(), request.getPlayerName())){
           return null;
        }
        User user = new User();
        user.setPlayerName(request.getPlayerName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCoins(0);
        user.setLevel(1);
        user.setExperience(0);
        user.setRequiredExperience(100);
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken, user.getId());
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername());
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken, user.getId());
    }

    public boolean checkForExistingUser(String username, String playerName){
        User foundUsername = repository.findByUsername(username);
        User foundPlayerName = repository.findByPlayerName(playerName);
        return foundUsername != null || foundPlayerName != null;
    }
}
