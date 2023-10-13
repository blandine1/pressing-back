package com.pressing.pressing.services;

import com.pressing.pressing.dto.RolesDto;

import java.util.List;

public interface RoleService {
    public RolesDto create(RolesDto rolesDto);
    List<RolesDto> findAll();
}
