package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.AuthenticationApi;
import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationApi {
    private  AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @Override
    public ResponseEntity<UtilisateurDto> register(UtilisateurDto utilisateurDto) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.signUp(utilisateurDto));
    }
//    @Override
//    public ResponseEntity<UtilisateurDto> authentication(UtilisateurDto request) {
//        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(request));
//    }

}
