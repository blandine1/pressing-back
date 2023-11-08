package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
@RequestMapping("/gestionpressing/v1/caissiere")
public interface UtilisateurApi {

    @GetMapping(value="/utilisateur/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('CAISSIERE')")
    UtilisateurDto findById(@PathVariable Integer id);
    @PostMapping(value = "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value =" /utilisateur/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByName(@PathVariable String name);

    @GetMapping(value= "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value="/utilisateur/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}