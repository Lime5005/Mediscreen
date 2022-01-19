package com.lime.mediscreen.service;

import com.lime.mediscreen.model.Patient;
import com.lime.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findByFirstName(String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    @Override
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }
}
