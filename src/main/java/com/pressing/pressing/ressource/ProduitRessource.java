package com.pressing.pressing.ressource;

import com.pressing.pressing.entity.HttpResponse;
import com.pressing.pressing.services.ProduitSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/")
public class ProduitRessource {
    private  final ProduitSortService produitSortService;

    @Autowired
    public ProduitRessource(ProduitSortService produitSortService) {
        this.produitSortService = produitSortService;
    }

    @GetMapping("/produits")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> firstName,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size){
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timestamp(now().toString())
                        .data(Map.of("page", produitSortService.getProduits("Johanna", page.orElse(0), size.orElse(10) )))
                        .message("product retrieve")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

}
