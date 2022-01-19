package com.lime.mediscreen.service;

import com.lime.mediscreen.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAllPatients();
    Patient findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
    Patient createPatient(Patient patient);
    Patient updatePatient(String firstName, Patient patientDetails);
    Boolean deletePatientByFirstName(String firstName);

}
