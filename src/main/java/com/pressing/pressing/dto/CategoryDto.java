package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Categorie;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String name;
    private Timestamp creationDate;
    private Timestamp lastUpdateDate;
    private String description;
    private Integer idutilisateur;

    public static CategoryDto fromEntity(Categorie categorie){
        if(categorie == null){
            return  null;
        }

        return CategoryDto.builder()
                .id(categorie.getId())
                .name(categorie.getName())
                .creationDate(categorie.getCreationDate())
                .lastUpdateDate(categorie.getLastUpdatedDate())
                .description(categorie.getDescription())
                .idutilisateur(categorie.getUtilisateurid())
                .build();
    }

    public static Categorie toEntity(CategoryDto categoryDto){
       if (categoryDto == null){
           return  null;
       }

       Categorie categorie = new Categorie();
       categorie.setId(categoryDto.getId());
       categorie.setName(categoryDto.getName());
       categorie.setCreationDate(categoryDto.getCreationDate());
       categorie.setLastUpdatedDate(categoryDto.getLastUpdateDate());
       categorie.setUtilisateurid(categoryDto.getIdutilisateur());
       categorie.setDescription(categoryDto.getDescription());

       return categorie;
    }
}
