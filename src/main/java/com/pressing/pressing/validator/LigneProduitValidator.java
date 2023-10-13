package com.pressing.pressing.validator;

import com.pressing.pressing.dto.LigneProduitDto;

import java.util.ArrayList;
import java.util.List;

public class LigneProduitValidator {
    public List<String> validator(LigneProduitDto ligneProduitDto){
        List<String> errors = new ArrayList<>();

        if(ligneProduitDto == null){
            errors.add("le prix est obligatoire");
        }

        if(ligneProduitDto.getPrix() == null){
            errors.add("le prix est obligatoire");
        }

        return errors;
    }
}
