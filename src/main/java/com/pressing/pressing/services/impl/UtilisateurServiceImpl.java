package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.Utilisateur;
import com.pressing.pressing.exception.ErrorCode;
import com.pressing.pressing.exception.InvalidEntityException;
import com.pressing.pressing.repository.UtilisateurRepository;
import com.pressing.pressing.services.UtilisateurService;
import com.pressing.pressing.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
            this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
       UtilisateurValidator utilisateurValidator = new UtilisateurValidator();
       List<String> errors = utilisateurValidator.validator(utilisateurDto);
       if(!errors.isEmpty()){
           log.error("l'utilisateur existe deja {}", utilisateurDto);
           throw new InvalidEntityException("l'utilisateur existe deja", ErrorCode.UTILISATEUR_ALREADY_EXIST, errors);
       }

      return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null){
            log.error("cet utilisateur avec le ID " + id + " n'existe pas");
        }
        Optional<Utilisateur> u =  utilisateurRepository.findById(id);
        UtilisateurDto utilisateurDto = UtilisateurDto.fromEntity(u.get());

        return Optional.of(utilisateurDto).orElseThrow(() ->
                new InvalidEntityException("Aucun utilisateur avec cet ID " + id + " trouvé", ErrorCode.UTILISATEUR_NOT_FOUND_EXCEPTION));
    }

    @Override
    public UtilisateurDto findByName(String name) {
        if(!StringUtils.hasLength(name)){
            log.error("veiuillez renseigner un nom");
            return  null;
        }
        Optional<Utilisateur> u = utilisateurRepository.findByName(name);
        UtilisateurDto utilisateurDto = UtilisateurDto.fromEntity(u.get());

        return Optional.of(utilisateurDto).orElseThrow(() ->
                new InvalidEntityException("aucun utilisateur n'existe avec ce nom", ErrorCode.UTILISATEUR_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("aucun utilisateur n'a été trouvé avec le ID "+ id);
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
