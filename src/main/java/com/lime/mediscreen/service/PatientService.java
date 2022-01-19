package com.lime.mediscreen.service;

import com.lime.mediscreen.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    Patient findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
}
