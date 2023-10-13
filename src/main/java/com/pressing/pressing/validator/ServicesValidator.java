package com.pressing.pressing.validator;

import com.pressing.pressing.dto.ServiceDto;

import java.util.ArrayList;
import java.util.List;

public class ServicesValidator {
    public List<String> validator(ServiceDto serviceDto){
        List<String> errors = new ArrayList<>();

        if(serviceDto == null){
            errors.add("le libellé est obligatoire");
        }

        if(serviceDto.getName() == null){
            errors.add("le libellé est obligatoire");
        }

      return errors;
    }
}
