package com.md.appointmentconsultationsservice.Clients;

import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENTS-DOCTORS-SERVICE")
public interface PatientClient {
    @GetMapping("/patients/find/{id}")
    @CircuitBreaker(name = "patientService", fallbackMethod = "getDefaultPatient")
    Patient getPatientById(@PathVariable("id") Long id);
    default Patient getDefaultPatient(Long id, Exception exception) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setNom("not available");
        patient.setEmail("not available");
        return patient;
    }
}
