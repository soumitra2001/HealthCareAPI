package com.example.DoctorConnect.repository;

import com.example.DoctorConnect.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {

}
