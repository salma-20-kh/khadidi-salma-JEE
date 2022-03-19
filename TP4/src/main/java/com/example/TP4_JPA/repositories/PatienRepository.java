package com.example.TP4_JPA.repositories;

import com.example.TP4_JPA.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name); // on suppose que c'est un nom unique
}
