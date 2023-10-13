package com.pressing.pressing.validator;

import com.pressing.pressing.dto.CategoryDto;
import com.pressing.pressing.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public List<String> validator(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("le numero de telephone de ce client est necessaire");
        }

        assert clientDto != null;
        if (clientDto.getPhoneNumber() == null){
            errors.add("le numero de telephone de ce client est necessaire");
        }

        return errors;
    }
}
