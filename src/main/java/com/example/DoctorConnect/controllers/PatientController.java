package com.example.DoctorConnect.controllers;

import com.example.DoctorConnect.models.Patient;
import com.example.DoctorConnect.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctorconnect/patient/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public String addPatient(@RequestBody @Valid Patient patient){
        return patientService.addPatient(patient);
    }

    @DeleteMapping("{id}/")
    public String deletePatientAccount(@PathVariable Long id){
        return patientService.deletePatient(id);
    }

    @GetMapping("{id}/")
    public String showSuggestion(@PathVariable Long id){
        return patientService.showSuggestion(id);
    }

}
