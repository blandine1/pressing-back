package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/client/create" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value = APP_ROOT + "/client/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/client/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByPhoneNumber(@PathVariable String phoneNumber);

    /**
     *
     * @return
     */
    @GetMapping(value = APP_ROOT + "/Client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    /**
     *
     * @param id
     */
    @DeleteMapping(value = APP_ROOT + "/client/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @PostMapping(value = APP_ROOT + "/client/update/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto update(@PathVariable Integer id, @RequestBody ClientDto clientDto);
}
