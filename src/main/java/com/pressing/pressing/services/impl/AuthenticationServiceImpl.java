package com.pressing.pressing.services.impl;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class AuthenticationServiceImpl {
/*
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(UtilisateurDto utilisateurDto) {
        var user = UtilisateurDto.builder()
                .name(utilisateurDto.getName())
                .prenom(utilisateurDto.getPrenom())
                .email(utilisateurDto.getEmail())
                .dateDeNaissance(utilisateurDto.getDateDeNaissance())
                .password(passwordEncoder.encode(utilisateurDto.getPassword()))
                .idRoles(utilisateurDto.getIdRoles())
                .build();
            UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(user)));
            var jwtToken = jwtService.generateToken(UtilisateurDto.toEntity(user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //System.out.println(request);
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println(request);
        var user = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken((user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }*/
}
