package com.example.tp6;


import com.example.tp6.Entities.Patient;
import com.example.tp6.Repositories.PatientRepository;
import com.example.tp6.security.Services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Tp6Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp6Application.class, args);
    }

    @Bean // au demarrage crée un objet de type PasswordEncoder
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null, "soukaina", new Date(), false, 120)
            );
            patientRepository.save(
                    new Patient(null, "salma", new Date(), false, 120)
            );
            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            });
        };
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("Mohamed", "1234", "1234");
            securityService.saveNewUser("Yassamine", "1234", "1234");
            securityService.saveNewUser("Hassan", "1234", "1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Mohamed","USER");
            securityService.addRoleToUser("Mohamed","ADMIN");
            securityService.addRoleToUser("Yassamine","USER");
            securityService.addRoleToUser("Hassan","USER");

        };
    }
}
