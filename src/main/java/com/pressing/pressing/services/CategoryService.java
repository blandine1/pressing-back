package com.pressing.pressing.services;

import com.pressing.pressing.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    CategoryDto findByName(String name);
    List<CategoryDto> findAll();
    void delete(Integer id);
}
