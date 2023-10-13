package com.pressing.pressing.services;

import com.pressing.pressing.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer id);
    UtilisateurDto findByName(String name);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
}
