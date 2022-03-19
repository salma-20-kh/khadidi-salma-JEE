package com.example.TP4_JPA.service;

import com.example.TP4_JPA.entities.Consultation;
import com.example.TP4_JPA.entities.Medecin;
import com.example.TP4_JPA.entities.Patient;
import com.example.TP4_JPA.entities.Rendez_vous;
import com.example.TP4_JPA.repositories.ConsultationRepository;
import com.example.TP4_JPA.repositories.MedecinRepository;
import com.example.TP4_JPA.repositories.PatienRepository;
import com.example.TP4_JPA.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional @AllArgsConstructor
public class HospitalServiceImpl implements IHospitalService{
    private PatienRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Rendez_vous saveRDV(Rendez_vous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
