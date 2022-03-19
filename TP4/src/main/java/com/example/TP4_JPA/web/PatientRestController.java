package com.example.TP4_JPA.web;

import com.example.TP4_JPA.entities.Patient;
import com.example.TP4_JPA.repositories.PatienRepository;
import com.sun.xml.bind.annotation.XmlIsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatienRepository patienRepository;
    @GetMapping("/patient")
    public List<Patient> patientsList(){
        return patienRepository.findAll();
    }
}
