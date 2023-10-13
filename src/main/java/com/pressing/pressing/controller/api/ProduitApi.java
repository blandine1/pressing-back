package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.LigneProduitDto;
import com.pressing.pressing.dto.ProduitDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface ProduitApi {

    @PostMapping(value = APP_ROOT+ "/produit/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto save(@RequestBody ProduitDto produitDto);

    @GetMapping(value = APP_ROOT+"/produit/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+"/produit/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAll();

    @PatchMapping(value = APP_ROOT+"/produit/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto updateStatut(@PathVariable Integer id);

    @PatchMapping(value = APP_ROOT+"/produit/update/{id}/{idLigneCommende}/{quantite}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto updateQuantiteProduit(@PathVariable Integer id, @PathVariable Integer idLigneCommende,@PathVariable  BigDecimal quantite);

    @PatchMapping(value = APP_ROOT+"/produit/update/{id}/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> updateClient(@PathVariable Integer id, @PathVariable Integer idClient);

    @GetMapping(value = APP_ROOT+"/produit/true/allTrue",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllTrue();

    @GetMapping(value = APP_ROOT+"/produit/false/allFalse",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllFalse();

    @PatchMapping(value = APP_ROOT+"/produit/update/service/{idProduit}/{idLigneProduit}/{idService}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> updateService(@PathVariable("idProduit") Integer idProduit, @PathVariable("idLigneProduit") Integer idLigneProduit,@PathVariable("idService")  Integer idService);
    @DeleteMapping(APP_ROOT+"/produit/delete/{idProduit}")
    void delete(@PathVariable("idProduit") Integer id);

    @GetMapping(value = APP_ROOT+"/produit/ligneProduit/{idProduit}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LigneProduitDto>> findAllLigneProduitByProduitId(@PathVariable("idProduit") Integer idProduit);

    @DeleteMapping(value = APP_ROOT+"/produit/delete/{idProduit}/{idLigneProduit}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> deleteProduit(@PathVariable("idProduit") Integer idProduit,@PathVariable("idLigneProduit") Integer idLigneProduit);
}