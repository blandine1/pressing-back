package com.pressing.pressing.validator;

import com.pressing.pressing.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
    public List<String> validator(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (categoryDto == null){
            errors.add("le nom de la categorie est obligatoire");
        }

        if (!StringUtils.hasLength(categoryDto.getName())){
            errors.add("le nom de la categorie est obligatoire");
        }

        return errors;
    }
}
