package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.ServiceDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface ServicesApi {
    @PostMapping(value = APP_ROOT + "/service/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto save(@RequestBody ServiceDto serviceDto);

    @GetMapping(value = APP_ROOT + "/service/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto findbyId(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/service/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ServiceDto findByName(@PathVariable String name);

    @GetMapping(value = APP_ROOT + "/service/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ServiceDto> findAll();

    @GetMapping(value = APP_ROOT + "/service/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(Integer id);
}
