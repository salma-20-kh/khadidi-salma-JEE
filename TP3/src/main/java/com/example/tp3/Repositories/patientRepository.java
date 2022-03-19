package com.example.tp3.Repositories;

import com.example.tp3.Entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


public interface patientRepository extends JpaRepository<patient,Long> {
    List<patient> findByMalade(Boolean m);
    //retourner les la liste des patients where malade=true dans la page x
    Page<patient> findByMalade(Boolean m,Pageable pageable);

    //retourner les la liste des patients where malade=true and score < valeur x
    List<patient> findByMaladeAndScoreLessThan(Boolean m,int score);

    //retourner les la liste des patients where DateNaissance between d1 and d2
    List<patient> findByDateNaissanceBetween(Date d1,Date d2);

    @Query("select p from patient p where p.dateNaissance between  :x and :y")
    List<patient> chercherPatients(@Param("x") Date d1, @Param("y")Date d2);
}
