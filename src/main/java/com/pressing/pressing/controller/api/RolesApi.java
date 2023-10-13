package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.RolesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface RolesApi {

    @PostMapping(value = APP_ROOT + "/role/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto create(@RequestBody RolesDto rolesDto);

    @GetMapping(value = APP_ROOT + "/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> fidAll();
}
