package com.pressing.pressing.repository;

import com.pressing.pressing.entity.Ligneproduit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneProduitRepository extends JpaRepository<Ligneproduit, Integer> {
    List<Ligneproduit> findAllByProduitId(Integer idProduit);
}
