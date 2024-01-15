package com.md.appointmentconsultationsservice.Clients;

import com.md.appointmentconsultationsservice.Model.Doctor;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENTS-DOCTORS-SERVICE", path = "/doctors")
public interface DoctorClient {
    @GetMapping("/find/{id}")
    @CircuitBreaker(name = "doctorService", fallbackMethod = "getDefaultDoctor")
    Doctor findById(@PathVariable("id") Long id);
    default Doctor getDefaultDoctor(Long id, Exception exception) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setNom("not available");
        doctor.setEmail("not available");
        doctor.setSpecialite("not available");
        return doctor;
    }


}
