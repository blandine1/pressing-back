package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.ServiceDto;
import com.pressing.pressing.entity.Services;
import com.pressing.pressing.exception.ErrorCode;
import com.pressing.pressing.exception.InvalidEntityException;
import com.pressing.pressing.repository.ServiceRepository;
import com.pressing.pressing.services.ServicesServices;
import com.pressing.pressing.validator.ServicesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServicesServicesImpl implements ServicesServices {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServicesServicesImpl(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceDto save(ServiceDto serviceDto) {
        ServicesValidator c = new ServicesValidator();
        List<String> errors = c.validator(serviceDto);
        if(!errors.isEmpty()){
            log.error("le service existe deja {}", serviceDto);
            throw  new InvalidEntityException("le service existe deja", ErrorCode.SERVICE_ALREADY_EXIST, errors);
        }
        return ServiceDto.fromEntity(serviceRepository.save(ServiceDto.toEntity(serviceDto)));
    }

    @Override
    public ServiceDto findbyId(Integer id) {
        if(id == null){
            log.error("Service Id is null");
            return  null;
        }
        Optional<Services> service = serviceRepository.findById(id);
        ServiceDto s = ServiceDto.fromEntity(service.get());

        return Optional.of(s).orElseThrow(() ->
                new InvalidEntityException("aucun Service disponible avec cet ID "+ id +" n'a été trouvé", ErrorCode.SERVICE_NOT_FOUND));
    }

    @Override
    public ServiceDto findByName(String name) {
        if(!StringUtils.hasLength(name)){
            log.error("le nom est null");
            return  null;
        }

        Optional<Services> service = serviceRepository.findByName(name);
        ServiceDto c = ServiceDto.fromEntity(service.get());

        return Optional.of(c).orElseThrow(() ->
                new InvalidEntityException("aucun service avec le nom "+ name +" n'a été trouvé", ErrorCode.SERVICE_NOT_FOUND));
    }

    @Override
    public List<ServiceDto> findAll() {
        return serviceRepository.findAll().stream()
                .map(ServiceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("aucun service trouvé avec cet ID "+ id);
            return;
        }
        serviceRepository.deleteById(id);
    }
}
