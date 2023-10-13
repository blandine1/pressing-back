package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT + "/utilisateur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + " /utilisateur/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByName(@PathVariable String name);

    @GetMapping(value = APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/utilisateur/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
