package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.ClientDto;
import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.entity.Client;
import com.pressing.pressing.exception.ErrorCode;
import com.pressing.pressing.exception.InvalidEntityException;
import com.pressing.pressing.repository.ClientRepository;
import com.pressing.pressing.services.ClientService;
import com.pressing.pressing.validator.ClientValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository  clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {

        List<String> errors = getStrings(clientDto);

        if(!errors.isEmpty()){
            log.error("le client existe deja {}", clientDto);
            throw new InvalidEntityException("le client existe deja", ErrorCode.CLIENT_ALREADY_EXIST, errors);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null){
            log.error("ce client avec le ID " + id + " n'existe pas");
        }
        Optional<Client> c =  clientRepository.findById(id);
        ClientDto clientDto = ClientDto.fromEntity(c.get());

        return Optional.of(clientDto).orElseThrow(() ->
                new InvalidEntityException("Aucun client avec cet ID " + id + " trouvé", ErrorCode.CLIENT_NOT_FOUND_EXCEPTION));
    }

    @Override
    public ClientDto findByPhoneNumber(String phoneNumber) {
        if(!StringUtils.hasLength(phoneNumber)){
            log.error("veiuillez renseigner un numero de ptelephone");
            return  null;
        }
        Optional<Client> c = clientRepository.findByPhoneNumber(phoneNumber);
        ClientDto clientDto = ClientDto.fromEntity(c.get());

        return Optional.of(clientDto).orElseThrow(() ->
                new InvalidEntityException("aucun client n'existe avec ce numero de telephone", ErrorCode.CLIENT_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("aucun client n'a été trouvé avec le ID "+ id);
            return;
        }
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {

        List<String> errors = getStrings(clientDto);

        if(!errors.isEmpty()){
            log.error("le client existe deja {}", clientDto);
            throw new InvalidEntityException("le client existe deja", ErrorCode.CLIENT_ALREADY_EXIST, errors);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    private static List<String> getStrings(ClientDto clientDto) {
        ClientValidator client= new ClientValidator();
        List<String> errors=client.validator(clientDto);
        return errors;
    }
}
