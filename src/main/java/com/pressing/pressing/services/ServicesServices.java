package com.pressing.pressing.services;

import com.pressing.pressing.dto.ServiceDto;

import java.util.List;

public interface ServicesServices {
    ServiceDto save(ServiceDto serviceDto);
    ServiceDto findbyId(Integer id);
    ServiceDto findByName(String name);
    List<ServiceDto> findAll();
    void delete(Integer id);
}
