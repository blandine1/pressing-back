package com.pressing.pressing.repository;

import com.pressing.pressing.dto.ProduitDto;
import com.pressing.pressing.entity.Ligneproduit;
import com.pressing.pressing.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    List<Produit> findAllByStatusIsTrue();
    List<Produit> findAllByStatusIsFalse();

}
