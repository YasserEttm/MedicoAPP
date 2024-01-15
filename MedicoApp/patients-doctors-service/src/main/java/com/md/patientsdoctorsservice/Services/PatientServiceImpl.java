package com.md.patientsdoctorsservice.Services;

import com.md.patientsdoctorsservice.Entities.Doctor;
import com.md.patientsdoctorsservice.Entities.Patient;
import com.md.patientsdoctorsservice.Repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
    @Override
    public Patient findById(Long id){
        if (patientRepository.findById(id).isEmpty()){
            return null;
        }
        return patientRepository.findById(id).get();
    }
    @Override
    public Patient savePatient(Patient patient){
        Patient pat = this.findById(patient.getId());

        if(pat == null){
            return patientRepository.save(patient);
        }
        return null;
    }
    @Override
    public Patient updatePatient(Patient patient){
        Patient pat = this.findById(patient.getId());
        return patientRepository.save(patient);

    }
    @Override
    public void deletePatient(Long id){
        Patient pat = this.findById(id);
        if(pat != null){
            patientRepository.deleteById(id);
        }
    }
}
