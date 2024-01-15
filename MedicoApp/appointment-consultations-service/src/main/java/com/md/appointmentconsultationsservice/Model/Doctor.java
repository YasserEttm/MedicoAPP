package com.md.appointmentconsultationsservice.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {
    private Long id;
    private String nom;
    private String email;
    private String specialite;
}
