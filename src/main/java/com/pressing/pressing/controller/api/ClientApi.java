package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
@RequestMapping("/gestionpressing/v1/caissiere")
public interface ClientApi {

    @PostMapping(value="/client/create" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value="/client/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable Integer id);

    @GetMapping(value="/client/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByPhoneNumber(@PathVariable String phoneNumber);

    /**
     *
     * @return
     */
    @GetMapping(value="/Client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    /**
     *
     * @param id
     */
    @DeleteMapping(value="/client/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @PostMapping(value="/client/update/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto update(@PathVariable Integer id, @RequestBody ClientDto clientDto);
}
