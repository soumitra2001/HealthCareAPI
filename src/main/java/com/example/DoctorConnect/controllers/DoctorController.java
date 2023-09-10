package com.example.DoctorConnect.controllers;

import com.example.DoctorConnect.models.Doctor;
import com.example.DoctorConnect.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctorconnect/")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public String addDoctor(@RequestBody @Valid Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("{id}/")
    public String deleteDoctorAccount(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }

}
