package com.pressing.pressing.controller;

import com.pressing.pressing.controller.api.CategorieApi;
import com.pressing.pressing.dto.CategoryDto;
import com.pressing.pressing.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategorieApi {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<CategoryDto> save(CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(categoryDto));
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByName(String name) {
        return categoryService.findByName(name);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
