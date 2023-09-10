package com.example.DoctorConnect.services;

import com.example.DoctorConnect.constants.Speciality;
import com.example.DoctorConnect.constants.Symptom;
import com.example.DoctorConnect.models.Doctor;
import com.example.DoctorConnect.models.Patient;
import com.example.DoctorConnect.repository.IDoctorRepo;
import com.example.DoctorConnect.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private IPatientRepo patientRepo;

    @Autowired
    private IDoctorRepo doctorRepo;

    public String addPatient(Patient patient) {
        Patient newPatient=patientRepo.save(patient);
        if(newPatient!=null)return "Patient added successfully...!";
        return "Unable to add the Patient";
    }

    public String deletePatient(Long id){
        List<Patient> patients=patientRepo.findAll();
        for(Patient patient:patients){
            if(patient.getPatientID()==id){
                patientRepo.deleteById(id);
                return "Patient account successfully deleted..!";
            }
        }
        return "Enter a valid Patient ID";
    }

    public String showSuggestion(Long id) {
        List<Patient> patients=patientRepo.findAll();
        StringBuffer suggestions=new StringBuffer();
        for(Patient patient:patients){
            if(patient.getPatientID()==id){
                if(patient.getSymptom().equals(Symptom.Arthritis) || patient.getSymptom().equals(Symptom.Back_Pain)
                || patient.getSymptom().equals(Symptom.Tissue_Injuries)){
                    suggestions.append("You need to visit a Orthopedic specialist.\n");
                    String city=patient.getPCity();
                    suggestions.append(getData(Speciality.Orthopedic,city));
                }else if(patient.getSymptom().equals(Symptom.Dysmenorrhea)){
                    suggestions.append("You need to visit a Gynecology specialist.\n");
                    String city=patient.getPCity();
                    suggestions.append(getData(Speciality.Gynecology,city));
                }else if(patient.getSymptom().equals(Symptom.Skin_Infection) || patient.getSymptom().equals(Symptom.Skin_Burn)){
                    suggestions.append("You need to visit a Dermatology specialist.\n");
                    String city=patient.getPCity();
                    suggestions.append(getData(Speciality.Dermatology,city));
                }else if(patient.getSymptom().equals(Symptom.Ear_Pain)){
                    suggestions.append("You need to visit a ENT specialist.\n");
                    String city=patient.getPCity();
                    suggestions.append(getData(Speciality.ENT_Specialist,city));
                }
            }
        }
        if(suggestions.isEmpty())suggestions.append("Please enter a valid Patient ID");

        return suggestions.toString();
    }

    public String getData(Speciality speciality,String city){
        StringBuffer suggestions=new StringBuffer();
        List<Doctor> doctors=doctorRepo.findAll();
        for(Doctor doctor:doctors){
            if(doctor.getSpeciality().equals(speciality) && doctor.getDCity().equals(city)){
                suggestions.append("You can book an appointment with Dr."+doctor.getDName()+", is "+ speciality.name() +" specialist \n");
                suggestions.append("Phone No: "+doctor.getDPhone_no()+"\n");
            }
        }
        if(suggestions.length()==0)suggestions.append("There isn’t any doctor present at your location for your symptom \n");

        return suggestions.toString();
    }
}
