package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Produit;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@ToString
public class ProduitDto {
    private Integer id;
    private Integer utilisateurid;
    private ClientDto client;
    private boolean status;
    private boolean livre;
    private String description;
    private Timestamp creationDate;
    private Timestamp lastUpdatedDate;
    private Double prixTotal;
    private List<LigneProduitDto> listeLigneProduit;

    public static ProduitDto fromEntity(Produit produit){
      if(produit == null){
        return  null;
      }

      return ProduitDto.builder()
              .id(produit.getId())
              .status(produit.isStatus())
              .livre(produit.isLivre())
              .utilisateurid(produit.getUtilisateurid())
              .description(produit.getDescription())
              .client(ClientDto.fromEntity(produit.getClient()))
              .creationDate(produit.getCreationDate())
              .prixTotal(produit.getPrixTotal())
              .lastUpdatedDate(produit.getLastUpdatedDate())
              .build();
    }

    public static Produit toEntity(ProduitDto produitDto){
        if (produitDto == null){
            return null;
        }

        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setStatus(produitDto.isStatus());
        produit.setLivre(produitDto.isLivre());
        produit.setDescription(produitDto.getDescription());
        produit.setUtilisateurid(produitDto.getUtilisateurid());
        produit.setClient(ClientDto.toEntity(produitDto.getClient()));
        produit.setCreationDate(produitDto.getCreationDate());
        produit.setLastUpdatedDate(produitDto.getLastUpdatedDate());
        produit.setPrixTotal(produitDto.getPrixTotal());
        return produit;
    }
}
