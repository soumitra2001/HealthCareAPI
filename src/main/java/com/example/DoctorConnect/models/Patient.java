package com.example.DoctorConnect.models;

import com.example.DoctorConnect.constants.Symptom;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientID;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]{3,20}")
    private String pName;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]{20}")
    private String pCity;

    @NotBlank
    @Email
    private String pEmail;

    @NotBlank
    @Pattern(regexp = "[0-9]{10,12}")
    private String pPhone_no;

    @NotBlank
    private Enum<Symptom> symptom;

}
