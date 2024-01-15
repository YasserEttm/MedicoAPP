package com.md.appointmentconsultationsservice.Service;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ConsultationService {

    List<Consultation> findAllConsultations();

    Optional<Consultation> findConsultationById(Long id);

    Consultation saveConsultation(Consultation consultation);

    Consultation updateConsultation(Long id, Consultation consultation);

    void deleteConsultation(Long id);
}
