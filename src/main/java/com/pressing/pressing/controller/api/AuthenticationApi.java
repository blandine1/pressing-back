package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.*;
import com.pressing.pressing.entity.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
@RequestMapping("/gestionpressing/v1/authentication")
public interface AuthenticationApi {
   // @PostMapping(value= "/register")
    //ResponseEntity<UtilisateurDto> register(@RequestBody UtilisateurDto utilisateurDto);
    @PostMapping(value= "/signup")
    ResponseEntity<Utilisateur> signup(@RequestBody SignUpRequest signUpRequest);

    @PostMapping(value= "/authenticate")
    ResponseEntity<JwtAuthenticationResponse> authentication(@RequestBody SignInRequest request);

    @PostMapping(value = "/refresh")
    ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest);
}
