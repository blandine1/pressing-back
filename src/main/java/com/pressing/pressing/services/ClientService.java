package com.pressing.pressing.services;

import com.pressing.pressing.dto.ClientDto;
import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.Client;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findById(Integer id);

    ClientDto findByPhoneNumber(String phoneNumber);

    List<ClientDto> findAll();
    void delete(Integer id);

    ClientDto updateClient(ClientDto clientDto);
}
