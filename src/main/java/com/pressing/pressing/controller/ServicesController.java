package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.ServicesApi;
import com.pressing.pressing.dto.ServiceDto;
import com.pressing.pressing.services.ServicesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketTimeoutException;
import java.util.List;

@RestController
public class ServicesController implements ServicesApi {
    private final ServicesServices servicesServices;

    @Autowired
    public ServicesController (ServicesServices servicesServices){
           this.servicesServices=servicesServices;
    }

    @Override
    public ServiceDto save(ServiceDto serviceDto) {
        System.out.println(serviceDto);
        return servicesServices.save(serviceDto);
    }

    @Override
    public ServiceDto findbyId(Integer id) {
        return servicesServices.findbyId(id);
    }

    @Override
    public ServiceDto findByName(String name) {
        return servicesServices.findByName(name);
    }

    @Override
    public List<ServiceDto> findAll() {
        return servicesServices.findAll();
    }

    @Override
    public void delete(Integer id) {
        servicesServices.delete(id);
    }
}
