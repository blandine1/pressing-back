package com.pressing.pressing.services.impl;

import com.pressing.pressing.config.JwtService;
import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.Role;
import com.pressing.pressing.repository.UtilisateurRepository;
import com.pressing.pressing.services.AuthenticationService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(UtilisateurRepository utilisateurRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService,
                                     AuthenticationManager authenticationManager
    ) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public UtilisateurDto signUp(UtilisateurDto utilisateurDto) {
        var user = UtilisateurDto.builder()
                .name(utilisateurDto.getName())
                .prenom(utilisateurDto.getPrenom())
                .email(utilisateurDto.getEmail())
                .dateDeNaissance(utilisateurDto.getDateDeNaissance())
                .role(Role.ADMIN)
                .password(passwordEncoder.encode(utilisateurDto.getPassword()))
                .build();

         return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(user)));
    }

//    @Override
//    public UtilisateurDto authenticate(UtilisateurDto request) {
//
//       authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        System.out.println(request);
//        var user = utilisateurRepository.findByEmail(request.getEmail())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken((user));
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
}