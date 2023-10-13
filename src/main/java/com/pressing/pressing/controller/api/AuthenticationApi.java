package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.AuthenticationRequest;
import com.pressing.pressing.entity.AuthenticationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

public interface AuthenticationApi {
    @PostMapping(value = APP_ROOT + "/authentication/register")
    ResponseEntity<AuthenticationResponse> register(@RequestBody UtilisateurDto utilisateurDto);

    @PostMapping(value = APP_ROOT + "/authentication/authenticate")
    ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request);
}
