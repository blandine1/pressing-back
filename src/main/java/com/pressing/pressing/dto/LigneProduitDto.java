package com.pressing.pressing.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pressing.pressing.entity.Ligneproduit;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private boolean status;
    //private Timestamp creationDate;
    //private Timestamp lastUpdatedDate;

    private Date creationDate;
    private Date lastUpdatedDate;
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
                .prixTotalPartiel(ligneproduit.getPrixTotalPartiel())
                .status(ligneproduit.isStatus())
                .creationDate(ligneproduit.getCreationDate())
                .lastUpdatedDate(ligneproduit.getLastUpdatedDate())
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
        ligneProduit.setPrixTotalPartiel(ligneProduitDto.getPrixTotalPartiel());
        ligneProduit.setServices(ServiceDto.toEntity(ligneProduitDto.getService()));
        ligneProduit.setStatus(ligneProduitDto.isStatus());
        ligneProduit.setCreationDate(ligneProduitDto.getCreationDate());
        ligneProduit.setLastUpdatedDate(ligneProduitDto.getLastUpdatedDate());

        return ligneProduit;
    }
}
