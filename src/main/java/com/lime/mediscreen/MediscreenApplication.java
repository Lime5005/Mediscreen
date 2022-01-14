package com.lime.mediscreen;

import com.lime.mediscreen.model.Patient;
import com.lime.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediscreenApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MediscreenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Patient("Alice", "Smith"));
        repository.save(new Patient("Bob", "Smith"));

        for (Patient patient : repository.findAll()) {
            System.out.println("patient = " + patient);
        }

        System.out.println(repository.findByFirstName("Alice"));

        for (Patient patient : repository.findByLastName("Smith")) {
            System.out.println(patient);
        }
    }
}
