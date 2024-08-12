package com.ust.patient_demo.repository;

import com.ust.patient_demo.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhone(String phone);

    Optional<Patient> findByEmailOrPhone(String email, String phone);

    @Query("select p from patient p where p.email like%?1%")
    Optional<Patient> searchByEmail(String email);
}
