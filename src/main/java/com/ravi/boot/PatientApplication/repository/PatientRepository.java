package com.ravi.boot.PatientApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.boot.PatientApplication.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
