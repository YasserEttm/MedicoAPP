package com.md.patientsdoctorsservice.Controllers;

import com.md.patientsdoctorsservice.Entities.Doctor;
import com.md.patientsdoctorsservice.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    private  DoctorService doctorService;

    @GetMapping(value = "/all")
    public List<Doctor> findAll(){
        return doctorService.getAllDoctor();
    }

    @GetMapping(value = "/find/{id}")
    public Doctor findById(@PathVariable Long id){
        return doctorService.findById(id);
    }

    @PostMapping(value = "/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @PostMapping(value = "/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }

}
