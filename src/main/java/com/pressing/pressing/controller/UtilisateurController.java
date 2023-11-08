package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.UtilisateurApi;
import com.pressing.pressing.dto.UtilisateurDto;
import com.pressing.pressing.services.UtilisateurService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/gestionpressing/v1/caissiere")
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){
          this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByName(String name) {
        return utilisateurService.findByName(name);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }

    @GetMapping()
    public ResponseEntity<String>getString(){
        return ResponseEntity.ok("bonhour ///////////////////////////");
    }
}
