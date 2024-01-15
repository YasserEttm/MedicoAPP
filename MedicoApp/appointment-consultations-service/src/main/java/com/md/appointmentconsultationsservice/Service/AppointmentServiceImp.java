package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Clients.DoctorClient;
import com.md.appointmentconsultationsservice.Clients.PatientClient;
import com.md.appointmentconsultationsservice.Entities.Appointment;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class AppointmentServiceImp implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    public AppointmentServiceImp(AppointmentRepository appointmentRepository, PatientClient patientClient, DoctorClient doctorClient) {
        this.appointmentRepository = appointmentRepository;
        this.patientClient = patientClient;
        this.doctorClient = doctorClient;
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointmentId(Long id) {
        return appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        Patient patient = patientClient.getPatientById(appointment.getPatient_id());
        Doctor doctor = doctorClient.findById(appointment.getDoctor_id());
        System.out.println(patient.getEmail());
        System.out.println(doctor.getEmail());
//        if (patient == null || doctor == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient or Doctor not found");
//        }
        Appointment newAppointment = new Appointment();
        newAppointment.setPatient_id(appointment.getPatient_id());
        newAppointment.setDoctor_id(appointment.getDoctor_id());
        newAppointment.setDateRDV(appointment.getDateRDV());
        newAppointment.setHeureRDV(appointment.getHeureRDV());
        newAppointment.setConsultation(appointment.getConsultation());
        return this.appointmentRepository.save(newAppointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment appointment1=appointmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Appointment not found"));
        appointment1.setDateRDV(appointment.getDateRDV());
        appointment1.setHeureRDV(appointment.getHeureRDV());
        return appointmentRepository.save(appointment1);}

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment= appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        appointmentRepository.delete(appointment);
    }


}
