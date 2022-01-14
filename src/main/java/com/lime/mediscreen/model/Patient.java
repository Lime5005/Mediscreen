package com.lime.mediscreen.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Patient {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String address;
    private String zipCode;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
