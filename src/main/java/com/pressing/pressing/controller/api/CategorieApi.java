package com.pressing.pressing.controller.api;

import com.pressing.pressing.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pressing.pressing.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "*")
public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categorie/create" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/categorie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/categorie/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByName(@PathVariable String name);

    @GetMapping(value = APP_ROOT + "/categorie/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categorie/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
