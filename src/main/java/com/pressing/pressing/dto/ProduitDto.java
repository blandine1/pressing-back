package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Client;
import com.pressing.pressing.entity.Ligneproduit;
import com.pressing.pressing.entity.Produit;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProduitDto {
    private Integer id;
    private Integer utilisateurid;
    private ClientDto client;
    private boolean status;
    private String description;
    private Date creationDate;
    private Double prixTotal;
    private List<LigneProduitDto> listeLigneProduit;

    public static ProduitDto fromEntity(Produit produit){
      if(produit == null){
        return  null;
      }

      return ProduitDto.builder()
              .id(produit.getId())
              .status(false)
              .utilisateurid(produit.getUtilisateurid())
              .description(produit.getDescription())
              .client(ClientDto.fromEntity(produit.getClient()))
              .creationDate(produit.getCreationDate())
              .build();
    }

    public static Produit toEntity(ProduitDto produitDto){
        if (produitDto == null){
            return null;
        }

        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setStatus(false);
        produit.setDescription(produitDto.getDescription());
        produit.setUtilisateurid(produitDto.getUtilisateurid());
        produit.setClient(ClientDto.toEntity(produitDto.getClient()));
        produit.setCreationDate(produitDto.getCreationDate());

        return produit;
    }
}
