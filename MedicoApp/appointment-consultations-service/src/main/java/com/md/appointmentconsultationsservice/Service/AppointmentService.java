package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> findAllAppointments();

    Appointment findAppointmentId(Long id);

    Appointment saveAppointment(Appointment appointment);

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long id);
}
