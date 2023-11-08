package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.ServiceDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
@RequestMapping("/gestionpressing/v1/caissiere")
public interface ServicesApi {
    @PostMapping(value="/service/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto save(@RequestBody ServiceDto serviceDto);

    @GetMapping(value="/service/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto findbyId(@PathVariable Integer id);

    @GetMapping(value="/service/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto findByName(@PathVariable String name);

    @GetMapping(value="/service/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ServiceDto> findAll();

    @GetMapping(value="/service/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);
}
