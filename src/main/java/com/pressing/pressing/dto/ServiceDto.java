package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Services;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceDto {
    private Integer id;
    private String name;
    private String description;
    private Integer utilisateurid;


    public static ServiceDto fromEntity(Services services){
        if(services == null){
            return  null;
        }

        return ServiceDto.builder()
                .id(services.getId())
                .name(services.getName())
                .utilisateurid(services.getUtilisateurid())
                .description(services.getDescription())
                .build();
    }

    public static Services toEntity(ServiceDto serviceDto){
        if (serviceDto == null){
            return  null;
        }

        Services services = new Services();
        services.setId(serviceDto.getId());
        services.setName(serviceDto.getName());
        services.setUtilisateurid(serviceDto.getUtilisateurid());
        services.setDescription(serviceDto.getDescription());

        return services;
    }
}
