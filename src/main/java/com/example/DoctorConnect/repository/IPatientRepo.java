package com.example.DoctorConnect.repository;

import com.example.DoctorConnect.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

}
