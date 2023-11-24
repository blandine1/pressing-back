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
@RequestMapping("/gestionpressing/v1/caissiere")
public interface ProduitApi {

    @PostMapping(value="/produit/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto save(@RequestBody ProduitDto produitDto);
    @PutMapping(value="/produit/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto update(@RequestBody ProduitDto produitDto);
    @GetMapping(value="/produit/alltrue/{phone}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllByPhoneNumberTrue(@PathVariable String phone);

    @GetMapping(value="/produit/allfalse/{phone}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllByPhoneNumberFalse(@PathVariable String phone);

    @GetMapping(value="/produit/livre/{phone}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProduitDto> findAllAndIsLivreTrue(@PathVariable String phone);

    @GetMapping(value="/produit/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto findById(@PathVariable Integer id);

    @GetMapping(value="/produit/findProduitLigneCommande/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto findByIdAndLigneProduit(@PathVariable Integer id);

    @GetMapping(value="/produit/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAll();

    @PutMapping(value="/produit/updateTrue/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto updateStatut(@PathVariable Integer id);

    @PatchMapping(value="/produit/update/{id}/{idLigneCommende}/{quantite}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto updateQuantiteProduit(@PathVariable Integer id, @PathVariable Integer idLigneCommende,@PathVariable  BigDecimal quantite);

    @PatchMapping(value="/produit/update/{id}/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> updateClient(@PathVariable Integer id, @PathVariable Integer idClient);

    @GetMapping(value="/produit/true/allTrue",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllTrue();

    @GetMapping(value="/produit/false/allFalse",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findAllFalse();

    @GetMapping(value="/produit/livre",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findBIsLivreTrue();

    @PatchMapping(value="/produit/update/service/{idProduit}/{idLigneProduit}/{idService}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> updateService(@PathVariable("idProduit") Integer idProduit, @PathVariable("idLigneProduit") Integer idLigneProduit,@PathVariable("idService")  Integer idService);
    @DeleteMapping(value="/produit/delete/{idProduit}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idProduit") Integer id);

    @GetMapping(value="/produit/ligneProduit/{idProduit}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LigneProduitDto>> findAllLigneProduitByProduitId(@PathVariable("idProduit") Integer idProduit);

    @DeleteMapping(value="/produit/delete/{idProduit}/{idLigneProduit}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProduitDto> deleteProduit(@PathVariable("idProduit") Integer idProduit,@PathVariable("idLigneProduit") Integer idLigneProduit);
}