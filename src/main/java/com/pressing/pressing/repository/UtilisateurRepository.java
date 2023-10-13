package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByName(String name);

    Optional<Utilisateur> findByEmail(String email);
}
