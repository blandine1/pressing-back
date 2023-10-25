package com.pressing.pressing.services.impl;

import com.pressing.pressing.entity.Produit;
import com.pressing.pressing.repository.ProduitSortRepository;
import com.pressing.pressing.services.ProduitSortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProduitSortServiceImpl implements ProduitSortService {

    @Autowired
    private ProduitSortRepository produitSortRepository;
    @Override
    public Page<Produit> getProduits(String firstName, int page, int size) {
        log.info("fetching data from database");

        return  produitSortRepository.findAll(firstName, PageRequest.of(page, size));
    }
}
