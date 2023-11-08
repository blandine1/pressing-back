package com.pressing.pressing.services.impl;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl
{
    //private final RoleRepository roleRepository;

  /*  @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
           this.roleRepository = roleRepository;
    }
    @Override
    public RolesDto create(RolesDto rolesDto) {
        RolesValidator role = new RolesValidator();
        List<String> error = role.validator(rolesDto);
        if(!error.isEmpty()){
             throw new InvalidEntityException("ce role existe deja", ErrorCode.ROLE_ULREADY_EXIST, error);
        }

        return RolesDto.fromEntity(roleRepository.save(RolesDto.toEntity(rolesDto)));
    }*/

//    @Override
//    public List<RolesDto> findAll() {
//        return roleRepository.findAll()
//                .stream().map(RolesDto::fromEntity)
//                .collect(Collectors.toList());
//    }
}
