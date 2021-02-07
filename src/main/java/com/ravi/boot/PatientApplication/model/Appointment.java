package com.ravi.boot.PatientApplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Appointment {
	
	@Column(name="appointmentId")
	Long appointmentId;
	
	@Column(name="patientId")
	Long patientId;
	
	@Column(name="doctorId")
	Long doctorId;
	
	@Column(name="doctorName")
	String doctorName;
	
	@Column(name="appointmentDate")
	Date appointmentDate;
	
	@Column(name="appointmentSlot")
	String appointmentSlot;

	public Appointment() {}
	
	public Appointment(Long appointmentId, Long patientId, Long doctorId, String doctorName, Date appointmentDate,
			String appointmentSlot) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.appointmentDate = appointmentDate;
		this.appointmentSlot = appointmentSlot;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentSlot() {
		return appointmentSlot;
	}

	public void setAppointmentSlot(String appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", doctorName=" + doctorName + ", appointmentDate=" + appointmentDate + ", appointmentSlot="
				+ appointmentSlot + "]";
	}
	
	
	

}
