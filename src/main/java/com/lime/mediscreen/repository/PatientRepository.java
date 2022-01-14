package com.lime.mediscreen.repository;

import com.lime.mediscreen.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
}
