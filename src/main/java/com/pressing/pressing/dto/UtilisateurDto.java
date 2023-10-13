package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private String name;
    private String prenom;
    private String email;
    private Date dateDeNaissance;
    private String password;
    private boolean status;
    private String photo;
    private Integer idRoles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur == null){
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .name(utilisateur.getName())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .password(utilisateur.getPassword())
                .photo(utilisateur.getPhoto())
                .status(utilisateur.isStatus())
                .idRoles(utilisateur.getIdRoles())
                .build();

    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return  null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setName(utilisateurDto.getName());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setStatus(utilisateurDto.isStatus());
        utilisateur.setPhoto(utilisateurDto.getPhoto());

        return utilisateur;
    }
}
