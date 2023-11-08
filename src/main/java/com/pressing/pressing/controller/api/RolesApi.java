package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.RolesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
@RequestMapping("/gestionpressing/v1/caissiere")
public interface RolesApi {

  /*  @PostMapping(value="/role/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RolesDto create(@RequestBody RolesDto rolesDto);

    @GetMapping(value="/roles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RolesDto> fidAll();*/
}
