package com.md.appointmentconsultationsservice.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.md.appointmentconsultationsservice.Model.Doctor;
import com.md.appointmentconsultationsservice.Model.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateRDV;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Date heureRDV;

    @OneToOne(cascade = CascadeType.ALL)
    private  Consultation consultation;

    private Long doctor_id;

    private Long patient_id;

    public void setHeureRDV(Date heureRDV) {
        if (heureRDV != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0); // Reset to epoch
            cal.set(Calendar.HOUR_OF_DAY, heureRDV.getHours());
            cal.set(Calendar.MINUTE, heureRDV.getMinutes());
            cal.set(Calendar.SECOND, heureRDV.getSeconds());
            this.heureRDV = cal.getTime();
        } else {
            this.heureRDV = null;
        }
    }

}
