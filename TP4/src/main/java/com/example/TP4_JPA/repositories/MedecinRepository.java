package com.example.TP4_JPA.repositories;

import com.example.TP4_JPA.entities.Medecin;
import com.example.TP4_JPA.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name); // on suppose que c'est un nom unique
}
