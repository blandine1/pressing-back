package com.pressing.pressing.validator;

import com.pressing.pressing.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public List<String> validator(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("le role est obligatoire");
        }

        if(rolesDto.getName() == null){
            errors.add("le role est obligatoire");
        }

      return errors;
    }
}
