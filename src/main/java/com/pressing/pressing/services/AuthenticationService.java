package com.pressing.pressing.services;

import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.AuthenticationRequest;
import com.pressing.pressing.entity.AuthenticationResponse;

public interface AuthenticationService {
    UtilisateurDto signUp(UtilisateurDto utilisateurDto);

    //AuthenticationResponse authenticate(AuthenticationRequest request);
}
