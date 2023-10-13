package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.ClientApi;
import com.pressing.pressing.dto.ClientDto;
import com.pressing.pressing.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto ClientDto) {
        return clientService.save(ClientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }


    @Override
    public ClientDto findByPhoneNumber(String phoneNumber) {
        return clientService.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }

    @Override
    public ClientDto update(Integer id, ClientDto clientDto) {
        clientDto.setId(id);
        return clientService.updateClient(clientDto);
    }
}