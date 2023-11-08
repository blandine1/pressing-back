package com.pressing.pressing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    private Integer id;
    private String name;
    private String description;


  /*  public static RolesDto fromEntity(Roles roles){
        if(roles == null){
            return  null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .name(roles.getName())
                .description(roles.getDescription())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return  null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setName(rolesDto.getName());
        roles.setDescription(rolesDto.getDescription());

        return roles;
    }*/
}
