package com.md.appointmentconsultationsservice.Controller;

import com.md.appointmentconsultationsservice.Entities.Consultation;
import com.md.appointmentconsultationsservice.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/all")
    public List<Consultation> getAllConsultations(){
        return consultationService.findAllConsultations();
    }

    @GetMapping("/find/{id}")
    public Optional<Consultation> getConsultationById(@PathVariable Long id){
        return consultationService.findConsultationById(id);
    }

    @PostMapping("/save")
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }

    @PutMapping("/{id}")
    public Consultation updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        return  consultationService.updateConsultation(id, consultation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
    }
}
