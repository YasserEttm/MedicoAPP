package com.md.appointmentconsultationsservice.Controller;

import com.md.appointmentconsultationsservice.Clients.DoctorClient;
import com.md.appointmentconsultationsservice.Clients.PatientClient;
import com.md.appointmentconsultationsservice.Entities.Appointment;
import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import com.md.appointmentconsultationsservice.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    public AppointmentController(AppointmentService appointmentService,PatientClient patientClient, DoctorClient doctorClient) {
        this.appointmentService = appointmentService;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments(){
        return appointmentService.findAllAppointments();
    }

    @GetMapping("/find/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.findAppointmentId(id);

    }

    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return  appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
