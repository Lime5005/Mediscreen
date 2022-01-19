package com.lime.mediscreen.controller;

import com.lime.mediscreen.exception.ResourceNotFoundException;
import com.lime.mediscreen.model.Patient;
import com.lime.mediscreen.repository.PatientRepository;
import com.lime.mediscreen.service.PatientService;
import com.lime.mediscreen.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping("/patients/one")
    public ResponseEntity<Patient> getPatientByFirstName(@RequestParam(value = "firstName") String firstName) throws ResourceNotFoundException {
        Patient patient = patientService.findByFirstName(firstName);
        if (patient == null) throw new ResourceNotFoundException("Patient not found with firstName: " + firstName);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/patients/family")
    public ResponseEntity<List<Patient>> getPatientsByLastName(@RequestParam(value = "lastName") String lastName) throws ResourceNotFoundException {
        List<Patient> patients = patientService.findByLastName(lastName);
        if (patients.isEmpty()) throw new ResourceNotFoundException("Patients not found with lastName: " + lastName);
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/patient/add")
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/patients/{firstName}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "firstName") String firstName, @Valid @RequestBody Patient patientDetails) throws ResourceNotFoundException {
        Patient patient = patientService.updatePatient(firstName, patientDetails);
        if (patient == null) throw new ResourceNotFoundException("Patient not found with firstName: " + firstName);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/patients/{firstName}")
    public Map<String, Boolean> deletePatient(@PathVariable(value = "firstName") String firstName) throws ResourceNotFoundException {
        Boolean deleted = patientService.deletePatientByFirstName(firstName);
        if (!deleted) throw new ResourceNotFoundException("Patient not found with firstName: " + firstName);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
