package com.pressing.pressing.services;

import com.pressing.pressing.dto.LigneProduitDto;
import com.pressing.pressing.dto.ProduitDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProduitService {
    ProduitDto save(ProduitDto produitDto);
    ProduitDto findById(Integer id);
    ProduitDto updateStatut(Integer id);
    ProduitDto updateQuantiteProduit(Integer id, Integer idLigneCommende, BigDecimal quantite);
    ProduitDto updateClient(Integer idProduit, Integer idClient);
    //ProduitDto alltrue(Integer idProduit);
    //ProduitDto allFalse(Integer idProduit);

    List<LigneProduitDto> findAllLigneProduitByProduitId(Integer idProduit);

    ProduitDto updateService(Integer idProduit, Integer idLigneProduit, Integer newIdService);

    ProduitDto deleteProduit(Integer idProduit, Integer idLigneProduit);

    List<ProduitDto> findAllTrue();
    List<ProduitDto> findAllFalse();
    List<ProduitDto> findAll();
    void delete(Integer id);
}
