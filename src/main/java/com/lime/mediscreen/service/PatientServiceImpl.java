package com.lime.mediscreen.service;

import com.lime.mediscreen.exception.ResourceNotFoundException;
import com.lime.mediscreen.model.Patient;
import com.lime.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findByFirstName(String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    @Override
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public Patient createPatient(Patient patient) {
        patient.setId(sequenceGeneratorService.generateSequence(Patient.SEQUENCE_NAME));
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(String firstName, Patient patientDetails) {
        Patient patient = patientRepository.findByFirstName(firstName);
        if (patient != null) {
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setBirthDate(patientDetails.getBirthDate());
            patient.setSex(patientDetails.getSex());
            patient.setAddress(patientDetails.getAddress());
            patient.setPhone(patientDetails.getPhone());
        } else return null;
        final Patient updatedPatient = patientRepository.save(patient);
        return updatedPatient;
    }

    @Override
    public Boolean deletePatientByFirstName(String firstName) {
        Boolean deleted = false;
        Patient patient = patientRepository.findByFirstName(firstName);
        if (patient != null) {
            patientRepository.deletePatientByFirstName(firstName);
            deleted = true;
        }
        return deleted;
    }
}
