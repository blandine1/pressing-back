package com.pressing.pressing.services;

import com.pressing.pressing.entity.Produit;
import org.springframework.data.domain.Page;

public interface ProduitSortService {
    Page<Produit> getProduits(String firstName, int page, int size);
}
