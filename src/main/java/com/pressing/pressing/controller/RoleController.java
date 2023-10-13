package com.pressing.pressing.controller;

import com.pressing.pressing.config.RestTanplateBuilder;
import com.pressing.pressing.controller.api.RolesApi;
import com.pressing.pressing.dto.RolesDto;
import com.pressing.pressing.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RolesApi {
    private final RoleService roleService;
    private final RestTanplateBuilder restTanplateBuilder;

    @Autowired
    public RoleController(RoleService roleService, RestTanplateBuilder restTanplateBuilder){
           this.roleService = roleService;
           this.restTanplateBuilder = restTanplateBuilder;
    }

    @Override
    public RolesDto create(RolesDto rolesDto) {
        return roleService.create(rolesDto);
    }

    @Override
    public List<RolesDto> fidAll() {
        return roleService.findAll();
    }
}
