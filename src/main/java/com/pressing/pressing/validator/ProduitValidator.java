package com.pressing.pressing.validator;

import com.pressing.pressing.dto.ProduitDto;

import java.util.ArrayList;
import java.util.List;

public class ProduitValidator {
    public List<String> validator(ProduitDto produitDto){
        List<String> errors = new ArrayList<>();

        if(produitDto == null){
            errors.add("le client est obligatoire");
        }

        assert produitDto != null;
        if (produitDto.getClient() == null){
            errors.add("le client de ce produit est obligatoire");
        }

//        if(produitDto.getUtilisateurid() == null){
//            errors.add("l'utilisateur est obligatoire");
//        }

      return errors;
    }
}
