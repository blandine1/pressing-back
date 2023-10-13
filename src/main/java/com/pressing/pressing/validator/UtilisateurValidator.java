package com.pressing.pressing.validator;

import com.pressing.pressing.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public List<String> validator(UtilisateurDto utilisateurDto){
            List<String> errors = new ArrayList<>();

            if(utilisateurDto == null){
                errors.add("le nom de l'utilisatilisateur est requis");
                errors.add("l'email de l'utilisatilisateur est requis");
                errors.add("la date de naissance de l'utilisatilisateur est requis");
                errors.add("le mot de passe de l'utilisatilisateur est requis");
            }

            if(!StringUtils.hasLength(utilisateurDto.getName())){
                errors.add("le nom de l'utilisatilisateur est requis");
            }

            if(!StringUtils.hasLength(utilisateurDto.getEmail())){
                errors.add("l'email de l'utilisatilisateur est requis");
            }

            if(utilisateurDto.getDateDeNaissance()==null){
                errors.add("la date de naissance de l'utilisatilisateur est requis");
            }

            if(!StringUtils.hasLength(utilisateurDto.getPassword())){
                errors.add("le mot de passe de l'utilisatilisateur est requis");
            }

            return  errors;
    }
}
