package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Appointment;
import com.md.appointmentconsultationsservice.Entities.Consultation;
import com.md.appointmentconsultationsservice.Repository.AppointmentRepository;
import com.md.appointmentconsultationsservice.Repository.ConsultationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Optional<Consultation> findConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation consultation) {
        Consultation result = consultationRepository.findById(consultation.getId()).get();
        Appointment appointment=result.getAppointment();
            appointmentRepository.save(consultation.getAppointment());
            return consultationRepository.save(consultation);
    }

    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with id " + id));
        consultationRepository.delete(consultation);
    }
}
