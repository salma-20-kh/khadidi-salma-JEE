package com.example.tp8.Repositories;

import com.example.tp8.Entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String kw, Pageable pageable);
    Page<Etudiant> findAll(Pageable pageable);
}
