package com.md.patientsdoctorsservice.Services;

import com.md.patientsdoctorsservice.Entities.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> getAllDoctor();
    public Doctor findById(Long id);
    public Doctor saveDoctor(Doctor doctor);
    public Doctor updateDoctor(Doctor doctor);
    public void deleteDoctor(Long id);
}
