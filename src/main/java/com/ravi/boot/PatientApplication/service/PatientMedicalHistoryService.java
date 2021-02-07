package com.ravi.boot.PatientApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.boot.PatientApplication.model.PatientMedicalHistory;
import com.ravi.boot.PatientApplication.repository.PatientMedicalHistoryRepository;

@Service
public class PatientMedicalHistoryService {
	
	@Autowired
	private PatientMedicalHistoryRepository PatientMedicalHistoryRepo;

	public List<PatientMedicalHistory> getAllPatientMedicalHistory() {
		List<PatientMedicalHistory> medHistories = new ArrayList<PatientMedicalHistory>();
		PatientMedicalHistoryRepo.findAll().forEach(p -> medHistories.add(p));
		return medHistories;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public PatientMedicalHistory getPatientMedicalHistoryById(long id) {
		return PatientMedicalHistoryRepo.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(PatientMedicalHistory PatientMedicalHistory) {
		PatientMedicalHistoryRepo.save(PatientMedicalHistory);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(long id) {
		PatientMedicalHistoryRepo.deleteById(id);
	}

	// updating a record
	public void update(PatientMedicalHistory PatientMedicalHistory, Long id) {
		PatientMedicalHistory updatedPatientMedicalHistory=getPatientMedicalHistoryById(id);
		updatedPatientMedicalHistory.setPatient(PatientMedicalHistory.getPatient());
		PatientMedicalHistoryRepo.save(updatedPatientMedicalHistory);
	}

}
