package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Categorie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String name;
    private String description;
    private Integer idutilisateur;

    public static CategoryDto fromEntity(Categorie categorie){
        //construire le DTO a partir de l'entite
        if(categorie == null){
            return  null;
        }

        return CategoryDto.builder()
                .id(categorie.getId())
                .name(categorie.getName())
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
       categorie.setUtilisateurid(categoryDto.getIdutilisateur());
       categorie.setDescription(categoryDto.getDescription());

       return categorie;
    }
}
