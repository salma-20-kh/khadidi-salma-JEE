package com.example.TP4_JPA.repositories;

import com.example.TP4_JPA.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
