package com.example.DoctorConnect.models;

import com.example.DoctorConnect.constants.City;
import com.example.DoctorConnect.constants.Speciality;
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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorID;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]{3,20}")
    private String dName;

    @NotBlank
    private Enum<City> dCity;

    @NotBlank
    @Email
    private String dEmail;

    @NotBlank
    @Pattern(regexp = "[0-9]{10,12}")
    private String dPhone_no;

    @NotBlank
    private Enum<Speciality> speciality;

}
