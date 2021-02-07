package com.ravi.boot.PatientApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ravi.boot.PatientApplication.enums.AffectedOrgan;

import io.swagger.annotations.ApiModel;

@Entity
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value="This is Patient Medical History class")
public class PatientMedicalHistory {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column
	@DecimalMin("0.0") 
	Double height;
	
	@Column
	@DecimalMin("0.0") 
	Double weight;
	
	@Column
	@DecimalMin("0.0") 
	Double bloodPressure;
	
	@Column
	@DecimalMin("0.0") 
	Double pulseRate;
	
	@Column
	AffectedOrgan affectedOrgan;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

	public PatientMedicalHistory() {}
	
	public PatientMedicalHistory(Long id, @DecimalMin("0.0") Double height, @DecimalMin("0.0") Double weight,
			@DecimalMin("0.0") Double bloodPressure, @DecimalMin("0.0") Double pulseRate, AffectedOrgan affectedOrgan,
			Patient patient) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.pulseRate = pulseRate;
		this.affectedOrgan = affectedOrgan;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(Double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Double getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Double pulseRate) {
		this.pulseRate = pulseRate;
	}

	public AffectedOrgan getAffectedOrgan() {
		return affectedOrgan;
	}

	public void setAffectedOrgan(AffectedOrgan affectedOrgan) {
		this.affectedOrgan = affectedOrgan;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "PatientMedicalHistory [id=" + id + ", height=" + height + ", weight=" + weight + ", bloodPressure="
				+ bloodPressure + ", pulseRate=" + pulseRate + ", affectedOrgan=" + affectedOrgan + ", patient="
				+ patient + "]";
	}
	
	
	
}
