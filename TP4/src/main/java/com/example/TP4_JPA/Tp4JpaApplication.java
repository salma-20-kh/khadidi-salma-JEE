package com.example.TP4_JPA;

import com.example.TP4_JPA.entities.*;
import com.example.TP4_JPA.repositories.ConsultationRepository;
import com.example.TP4_JPA.repositories.MedecinRepository;
import com.example.TP4_JPA.repositories.PatienRepository;
import com.example.TP4_JPA.repositories.RendezVousRepository;
import com.example.TP4_JPA.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp4JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp4JpaApplication.class, args);
	}

	@Bean // pour démarrer cette méthode au démarage
	CommandLineRunner start(IHospitalService hospitalService, PatienRepository patienRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository){
		return args ->{
			Stream.of("soukaina","salma","najat").forEach(name-> {
						hospitalService.savePatient(new Patient(null, name, new Date(), false, null));
					});
			/*
			Stream.of("soukaina","salma","najat").forEach(name-> {
				Patient patient=new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				patientRepository.save(patient);
			});
			 */

			Stream.of("soukaina2","salma2","najat2").forEach(name-> {
				Medecin medecin=new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.saveMedecin(medecin);
			});

			Patient patient=patienRepository.findById(1L).orElse(null);
			Patient patient1=patienRepository.findByNom("soukaina");

			Medecin medecin = medecinRepository.findByNom("soukaina2");

			Rendez_vous rendezVous = new Rendez_vous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			hospitalService.saveRDV(rendezVous);
			Rendez_vous savedRDV = hospitalService.saveRDV(rendezVous);
			System.out.println(savedRDV.getId());

			//Rendez_vous rendezVous2 = rendezVousRepository.findById(1L).orElse(null);
			Rendez_vous rendezVous2 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous2);
			consultation.setRapport("à ecrire apres");
			hospitalService.saveConsultation(consultation);
		};
	}

}
