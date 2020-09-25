package com.ditryx.hangover.controllers;

import com.ditryx.hangover.DAO.UserService;
import com.ditryx.hangover.DTO.input.AuthenticationRequestDTO;
import com.ditryx.hangover.DTO.input.RegistrationUserDTO;
import com.ditryx.hangover.entities.User;
import com.ditryx.hangover.security.JWT.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }


    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDTO){

        try {

            String login = requestDTO.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, requestDTO.getPassword()));
            User user = userService.findByLogin(login);

            if (user == null) {
                throw new UsernameNotFoundException("User with login " + login + " not found");
            }

            String token = jwtTokenProvider.createToken(login, user.getRoles());

            Map<Object, Object> response = new HashMap<>(); //можно вместо этого сделать DTO

            response.put("login", login);
            response.put("token", token);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (AuthenticationServiceException e) {
            throw new BadCredentialsException("Invalid login or password");
        }
    }

    @PostMapping("register")
    public ResponseEntity register (@RequestBody RegistrationUserDTO registrationUserDTO){

        User user = registrationUserDTO.toEntity();
        userService.register(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
