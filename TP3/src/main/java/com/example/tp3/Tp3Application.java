package com.example.tp3;

import com.example.tp3.Entities.patient;
import com.example.tp3.Repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private patientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(Tp3Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        //la methode save() est héritée de JPA
        for(int i=0;i<50;i++){
            patientRepository.save(new patient(null,"salma",new Date(),Math.random()>1?true:false,(int)Math.random()));

        }


        List<patient> patients=patientRepository.findAll();
        patients.forEach(patient ->{
            System.out.println("----------------------");
            System.out.println(patient.getNom());
            System.out.println(patient.getMalade());
        });


        //retourner les 5 premiers patients
        Page<patient> patientsPage=patientRepository.findAll(PageRequest.of(0,5));
        patientsPage.forEach(patient ->{
            System.out.println("----------------------");
            System.out.println(patient.getNom());
            System.out.println(patient.getMalade());
        });

        System.out.println("nombre de pages:"+patientsPage.getTotalPages());
        System.out.println("nombre d'éléments:"+patientsPage.getTotalElements());
        System.out.println("numéro de page courante:"+patientsPage.getNumber());

        List<patient> patientsByMalade=patientRepository.findByMalade(true);
        patientsByMalade.forEach(patient ->{
            System.out.println("----------------------");
            System.out.println(patient.getNom());
            System.out.println(patient.getMalade());
        });

        Page<patient> patientsByMaladePage=patientRepository.findByMalade(true,PageRequest.of(1,5));
        patientsByMaladePage.forEach(patient ->{
            System.out.println("----------------------");
            System.out.println(patient.getNom());
            System.out.println(patient.getMalade());
        });

    }
}
