package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public static  ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return  null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return client;

    }
}
