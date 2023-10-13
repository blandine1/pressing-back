package com.pressing.pressing.services.impl;

import com.pressing.pressing.dto.CategoryDto;
import com.pressing.pressing.entity.Categorie;
import com.pressing.pressing.exception.ErrorCode;
import com.pressing.pressing.exception.InvalidEntityException;
import com.pressing.pressing.repository.CategorieRepository;
import com.pressing.pressing.services.CategoryService;
import com.pressing.pressing.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategoryServiceImpl(CategorieRepository categorieRepository){
      this.categorieRepository = categorieRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        CategorieValidator c = new CategorieValidator();
        List<String> errors = c.validator(categoryDto);
        if(!errors.isEmpty()){
            log.error("la categorie existe deja {}", categoryDto);
            throw  new InvalidEntityException("la categorie existe deja", ErrorCode.CATENORIE_ALREADY_EXIST, errors);
        }
        return CategoryDto.fromEntity(categorieRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Categorie Id is null");
            return  null;
        }
        Optional<Categorie> categorie = categorieRepository.findById(id);
        CategoryDto c = CategoryDto.fromEntity(categorie.get());

        return Optional.of(CategoryDto.fromEntity(categorie.get())).orElseThrow(() ->
        new InvalidEntityException("aucune categorie avec cet ID "+ id +" n'a été trouvé", ErrorCode.CATENORIE_NOT_FOUND));
    }

    @Override
    public CategoryDto findByName(String name) {
        if(!StringUtils.hasLength(name)){
            log.error("le nom est null");
            return  null;
        }

        Optional<Categorie> categorie= categorieRepository.findByName(name);
        CategoryDto c = CategoryDto.fromEntity(categorie.get());

        return Optional.of(c).orElseThrow(() ->
                new InvalidEntityException("aucune categorie avec le nom "+ name +" n'a été trouvé", ErrorCode.CATENORIE_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
      if(id == null){
          log.error("aucune categorie avec cet ID "+id);
          return;
      }
      categorieRepository.deleteById(id);
    }
}
