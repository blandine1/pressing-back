package com.pressing.pressing;

import com.pressing.pressing.entity.Client;
import com.pressing.pressing.entity.Ligneproduit;
import com.pressing.pressing.entity.Produit;
import com.pressing.pressing.entity.Services;
import com.pressing.pressing.repository.ClientRepository;
import com.pressing.pressing.repository.LigneProduitRepository;
import com.pressing.pressing.repository.ProduitRepository;
import com.pressing.pressing.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProduitTest {
    
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    LigneProduitRepository ligneProduitRepository;
    @Autowired
    ServiceRepository serviceRepository;
    
    @Autowired
    ClientRepository clientRepository;
    
    @Test
    public void testSaveProduit(){
        
        int serviceId=1;
        int clientId=1;
        Services services = serviceRepository.findById(serviceId).get();
        Client client = clientRepository.findById(clientId).get();

        Produit  produit= new Produit();
        produit.setClientid(1);
        produit.setCreationDate(new Date());
        produit.setStatus(false);
        produit.setUtilisateurid(1);

        Ligneproduit ligneproduit1= new Ligneproduit();
        ligneproduit1.setId_produit(2);
        ligneproduit1.setVetement("veste carree");
        ligneproduit1.setPrix(8000);
        ligneproduit1.setQuantite(BigDecimal.valueOf(3));
        ligneproduit1.setServices(services);

    }

}
