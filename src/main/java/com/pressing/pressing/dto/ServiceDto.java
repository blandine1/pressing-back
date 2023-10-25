package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Services;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@ToString
public class ServiceDto {
    private Integer id;
    private String name;
    private Timestamp creationDate;
    private Timestamp lastUpdatedDate;
    private String description;
    private Integer utilisateurid;


    public static ServiceDto fromEntity(Services services){
        if(services == null){
            return  null;
        }

        return ServiceDto.builder()
                .id(services.getId())
                .name(services.getName())
                .creationDate(services.getCreationDate())
                .lastUpdatedDate(services.getLastUpdatedDate())
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
        services.setCreationDate(serviceDto.creationDate);
        services.setLastUpdatedDate(serviceDto.getLastUpdatedDate());
        services.setUtilisateurid(serviceDto.getUtilisateurid());
        services.setDescription(serviceDto.getDescription());

        return services;
    }
}
