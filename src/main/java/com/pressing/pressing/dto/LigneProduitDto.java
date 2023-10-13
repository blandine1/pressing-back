package com.pressing.pressing.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pressing.pressing.entity.Ligneproduit;
import com.pressing.pressing.entity.Produit;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneProduitDto {
    private Integer id;
    private Integer prix;
    private BigDecimal quantite;
    private String description;
    private ServiceDto service;
    private String vetement;
    private Integer id_produit;
    private Double prixTotalPartiel;
    @JsonIgnore
    private CategoryDto categoryDto;

    public static LigneProduitDto fromEntity(Ligneproduit ligneproduit){
        if(ligneproduit == null){
          return  null;
        }

        return LigneProduitDto.builder()
                .id(ligneproduit.getId())
                .prix(ligneproduit.getPrix())
                .quantite(ligneproduit.getQuantite())
                .id_produit(ligneproduit.getId_produit())
                .service(ServiceDto.fromEntity(ligneproduit.getServices()))
                .description(ligneproduit.getDescription())
                .vetement(ligneproduit.getVetement())
                .build();
    }

    public static Ligneproduit toEntity(LigneProduitDto ligneProduitDto){
       if (ligneProduitDto == null){
         return  null;
       }
       Ligneproduit ligneProduit = new Ligneproduit();
        ligneProduit.setId(ligneProduitDto.getId());
        ligneProduit.setPrix(ligneProduitDto.getPrix());
        ligneProduit.setQuantite(ligneProduitDto.getQuantite());
        ligneProduit.setVetement(ligneProduitDto.getVetement());
        ligneProduit.setDescription(ligneProduitDto.getDescription());
        ligneProduit.setId_produit(ligneProduit.getId_produit());
        ligneProduit.setServices(ServiceDto.toEntity(ligneProduitDto.getService()));

        return ligneProduit;
    }
}
