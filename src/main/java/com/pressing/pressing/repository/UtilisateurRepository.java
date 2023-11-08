package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByName(String name);

    Optional<Utilisateur> findByEmail(String email);

    //Optional<Utilisateur> findByRole(Role role);
}
