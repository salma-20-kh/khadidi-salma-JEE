package com.example.TP4_JPA.service;

import com.example.TP4_JPA.entities.Consultation;
import com.example.TP4_JPA.entities.Medecin;
import com.example.TP4_JPA.entities.Patient;
import com.example.TP4_JPA.entities.Rendez_vous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Rendez_vous saveRDV(Rendez_vous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
