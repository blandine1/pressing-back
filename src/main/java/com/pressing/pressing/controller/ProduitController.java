package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.ProduitApi;
import com.pressing.pressing.dto.LigneProduitDto;
import com.pressing.pressing.dto.ProduitDto;
import com.pressing.pressing.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    public ProduitDto update(ProduitDto produitDto) {
        return produitService.update(produitDto);
    }

    @Override
    public List<ProduitDto> findAllByPhoneNumberTrue(String phone) {
        return produitService.findAllByPhoneNumberTrue(phone);
    }

    @Override
    public List<ProduitDto> findAllByPhoneNumberFalse(String phone) {
        return produitService.findAllByPhoneNumberFalse(phone);
    }

    @Override
    public List<ProduitDto> findAllAndIsLivreTrue(String phone) {
        return produitService.findAllAndIsLivreTrue(phone);
    }

    @Override
    public ProduitDto findById(Integer id) {
        return produitService.findById(id);
    }

    public ProduitDto findByIdAndLigneProduit(Integer id){
        return produitService.findByIdAndLigneProduit(id);
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
    public List<ProduitDto> findAllPayeTrue() {
        return  produitService.findAllPayeTrue();
    }

    @Override
    public List<ProduitDto> findAllStatusFalse() {
        return produitService.findAllStatusFalse();
    }

    @Override
    public List<ProduitDto> findBIsLivreTrue() {
        return produitService.findBIsLivreTrue();
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
