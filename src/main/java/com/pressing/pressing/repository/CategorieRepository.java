package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository  extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findByName(String name);
}
