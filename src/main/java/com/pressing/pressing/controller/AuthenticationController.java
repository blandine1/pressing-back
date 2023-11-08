package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.AuthenticationApi;
import com.pressing.pressing.dto.*;
import com.pressing.pressing.entity.Utilisateur;
import com.pressing.pressing.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//implements AuthenticationApi
public class AuthenticationController  {
    //private final AuthenticationService authenticationService;

   /* @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("bomjour ///////////////////");
    }

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @Override
    public ResponseEntity<Utilisateur> signup(SignUpRequest signUpRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.signup(signUpRequest));
    }

    @Override
    public ResponseEntity<JwtAuthenticationResponse> authentication(SignInRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(request));
    }
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.refereshToken(refreshTokenRequest));
    }*/
}