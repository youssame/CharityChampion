package com.charitychampion.charitychampion.security.services;

import com.charitychampion.charitychampion.security.dto.AuthenticationRequest;
import com.charitychampion.charitychampion.security.dto.AuthenticationResponse;
import com.charitychampion.charitychampion.security.dto.LoginRequest;
import com.charitychampion.charitychampion.security.entities.User;
import com.charitychampion.charitychampion.security.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(AuthenticationRequest authenticationRequest) {
        User user = User.builder()
                .fullname(authenticationRequest.getFullname())
                .username(authenticationRequest.getUsername())
                .password(passwordEncoder.encode(authenticationRequest.getPassword()))
                .role(authenticationRequest.getRole())
                .status(authenticationRequest.getStatus())
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return new AuthenticationResponse(token, refreshToken);
    }
    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        // TODO : Revoke all user tokens
        return new AuthenticationResponse(token, refreshToken);
    }
}
