package com.md.appointmentconsultationsservice.Repository;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
