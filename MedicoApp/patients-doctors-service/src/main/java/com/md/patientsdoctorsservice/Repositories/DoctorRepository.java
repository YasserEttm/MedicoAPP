package com.md.patientsdoctorsservice.Repositories;

import com.md.patientsdoctorsservice.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
