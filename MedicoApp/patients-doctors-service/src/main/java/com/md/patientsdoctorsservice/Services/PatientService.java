package com.md.patientsdoctorsservice.Services;


import com.md.patientsdoctorsservice.Entities.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatient();
    public Patient findById(Long id);
    public Patient savePatient(Patient doctor);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Long id);
}
