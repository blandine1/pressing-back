package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.*;
import com.pressing.pressing.entity.Role;
import com.pressing.pressing.entity.Utilisateur;
import com.pressing.pressing.repository.UtilisateurRepository;
import com.pressing.pressing.services.AuthenticationService;
import com.pressing.pressing.services.JWTService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

//@Service
//@Builder
//implements AuthenticationService
public class AuthenticationServiceImpl {

/*
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(UtilisateurRepository utilisateurRepository,
                                     PasswordEncoder passwordEncoder,
                                     JWTService jwtService, AuthenticationManager authenticationManager
    ) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Utilisateur signup(SignUpRequest signUpRequest) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(signUpRequest.getPrenom());
        utilisateur.setRole(Role.CAISSIERE);
        utilisateur.setName(signUpRequest.getName());
        utilisateur.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        utilisateur.setEmail(signUpRequest.getEmail());

         return utilisateurRepository.save(utilisateur);
    }

    @Override
    public JwtAuthenticationResponse authenticate(SignInRequest signInRequest){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
       );
        var user = utilisateurRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();
        authenticationResponse.setToken(jwt);
        authenticationResponse.setRefreshtoken(refreshToken);

        return authenticationResponse;
    }

    @Override
    public JwtAuthenticationResponse refereshToken(RefreshTokenRequest tokenRequest){
        //avec cette methode tu peux manipuler ou bien get le current user
        String userEmail = jwtService.extractUserName(tokenRequest.getToken());
        Utilisateur utilisateur = utilisateurRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(tokenRequest.getToken(), utilisateur)){
            var jwt = jwtService.generateToken( utilisateur);

            JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();
            authenticationResponse.setToken(jwt);
            authenticationResponse.setRefreshtoken(tokenRequest.getToken());

            return authenticationResponse;
        }

        return  null;
    }
*/

}