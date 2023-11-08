package com.pressing.pressing;

import com.pressing.pressing.entity.Role;
import com.pressing.pressing.entity.Utilisateur;
import com.pressing.pressing.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.Date;

@SpringBootApplication
//implements CommandLineRunner
public class PressingApplication {

    //@Autowired
    //private UtilisateurRepository utilisateurRepository;
    public static void main(String[] args) {
        SpringApplication.run(PressingApplication.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {

            Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1.setRole(Role.ADMIN);
            utilisateur1.setName("sonore12");
            utilisateur1.setPrenom("luc12");
            utilisateur1.setStatut(true);
            utilisateur1.setPassword(new BCryptPasswordEncoder().encode("sonore12"));
            utilisateur1.setEmail("sonore12@gmail.com");
            utilisateur1.setDateDeNaissance(new Date());

            utilisateurRepository.save(utilisateur1);

    }*/
}
