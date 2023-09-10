package com.example.DoctorConnect.services;

import com.example.DoctorConnect.models.Doctor;
import com.example.DoctorConnect.models.Patient;
import com.example.DoctorConnect.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepo doctorRepo;

    public String addDoctor(Doctor doctor) {
        Doctor newDoctor=doctorRepo.save(doctor);
        if(newDoctor!=null)return "Doctor added successfully...!";
        return "Unable to add the Doctor";
    }

    public String deleteDoctor(Long id){
        List<Doctor> doctors=doctorRepo.findAll();
        for(Doctor doctor:doctors){
            if(doctor.getDoctorID()==id){
                doctorRepo.deleteById(id);
                return "Doctor account successfully deleted..!";
            }
        }
        return "Enter a valid Doctor ID";
    }

}
