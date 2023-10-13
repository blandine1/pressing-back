package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.ProduitApi;
import com.pressing.pressing.dto.LigneProduitDto;
import com.pressing.pressing.dto.ProduitDto;
import com.pressing.pressing.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProduitController implements ProduitApi {
    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService){
        this.produitService = produitService;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @Override
    public ProduitDto findById(Integer id) {
        return produitService.findById(id);
    }

    @Override
    public ProduitDto updateStatut(Integer id) {
        return produitService.updateStatut(id);
    }

    @Override
    public ProduitDto updateQuantiteProduit(Integer id, Integer idLigneCommende, BigDecimal quantite) {
        return produitService.updateQuantiteProduit(id, idLigneCommende, quantite);
    }

    @Override
    public ResponseEntity<ProduitDto> updateClient(Integer id, Integer idClient) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produitService.updateClient(id, idClient));
    }

    @Override
    public List<ProduitDto> findAllTrue() {
        return  produitService.findAllTrue();
    }

    @Override
    public List<ProduitDto> findAllFalse() {
        return produitService.findAllFalse();
    }

    @Override
    public ResponseEntity<ProduitDto> updateService(Integer idProduit, Integer idLigneProduit, Integer idService) {
        return ResponseEntity.ok(produitService.updateService(idProduit, idLigneProduit, idService));
    }

    @Override
    public ResponseEntity<ProduitDto> deleteProduit(Integer idProduit, Integer idLigneProduit) {
        return ResponseEntity.ok(produitService.deleteProduit(idProduit, idLigneProduit));
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }

    @Override
    public ResponseEntity<List<LigneProduitDto>> findAllLigneProduitByProduitId(Integer idProduit) {
        return ResponseEntity.ok(produitService.findAllLigneProduitByProduitId(idProduit));
    }

    @Override
    public void delete(Integer id) {
        produitService.delete(id);
    }
}
