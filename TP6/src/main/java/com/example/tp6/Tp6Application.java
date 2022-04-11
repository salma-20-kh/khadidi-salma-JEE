package com.example.tp6;


import com.example.tp6.Entities.Patient;
import com.example.tp6.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp6Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp6Application.class, args);
    }

    @Bean
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
}
