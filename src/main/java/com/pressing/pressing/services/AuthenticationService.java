package com.pressing.pressing.services;

import com.pressing.pressing.dto.*;
import com.pressing.pressing.entity.Utilisateur;

public interface AuthenticationService {
    //UtilisateurDto signUp(UtilisateurDto utilisateurDto);

    JwtAuthenticationResponse refereshToken(RefreshTokenRequest tokenRequest);

    //UtilisateurDto signup(UtilisateurDto utilisateurDto);

    Utilisateur signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse authenticate(SignInRequest signInRequest);
}