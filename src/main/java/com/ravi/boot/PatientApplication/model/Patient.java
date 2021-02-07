package com.ravi.boot.PatientApplication.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ravi.boot.PatientApplication.audit.Auditable;
import com.ravi.boot.PatientApplication.enums.Gender;

import io.swagger.annotations.ApiModel;

@Entity
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "This is patient class")
public class Patient extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@Size(max = 20, min = 5, message = "Invalid Patient First Name !!")
	private String patientfirstName;

	@Column
	@Size(max = 20, min = 5, message = "Invalid Patient Last Name !!")
	private String patientlastName;

	@Column
	@Email(message = "Email should be valid!!")
	private String email;

	@Column
	@Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$/", message = "Invalid phone number!!")
	private String phoneNumber;

	@Column
	private Gender gender;

	@Column
	@NotEmpty(message = "Address is required!! ")
	private String address;

	@Column
	@NotEmpty(message = "City is required!! ")
	@Size(min = 3, message = "Minimum 3 characters in length!!")
	private String city;
	@Column
	@NotEmpty(message = "State is required!! ")
	@Size(min = 3, message = "Minimum 3 characters in length!!")
	private String state;

	@Past(message = "Date input is invalid for a birth date.")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;

	@Column
	@Size(min = 3, message = "Invalid SSN number !!")
	private String ssn;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	private PatientMedicalHistory patientMedHistory;

	public Patient() {
	}

	public Patient(long id, @Size(max = 20, min = 5, message = "Invalid Patient First Name !!") String patientfirstName,
			@Size(max = 20, min = 5, message = "Invalid Patient Last Name !!") String patientlastName,
			@Email(message = "Email should be valid!!") String email,
			@Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$/", message = "Invalid phone number!!") String phoneNumber,
			Gender gender, @NotEmpty(message = "Address is required!! ") String address,
			@NotEmpty(message = "City is required!! ") @Size(min = 3, message = "Minimum 3 characters in length!!") String city,
			@NotEmpty(message = "State is required!! ") @Size(min = 3, message = "Minimum 3 characters in length!!") String state,
			@Past(message = "Date input is invalid for a birth date.") Date dateOfBirth,
			@Size(min = 3, message = "Invalid SSN number !!") String ssn, PatientMedicalHistory patientMedHistory) {
		super();
		this.id = id;
		this.patientfirstName = patientfirstName;
		this.patientlastName = patientlastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
		this.ssn = ssn;
		this.patientMedHistory = patientMedHistory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatientfirstName() {
		return patientfirstName;
	}

	public void setPatientfirstName(String patientfirstName) {
		this.patientfirstName = patientfirstName;
	}

	public String getPatientlastName() {
		return patientlastName;
	}

	public void setPatientlastName(String patientlastName) {
		this.patientlastName = patientlastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public PatientMedicalHistory getPatientMedHistory() {
		return patientMedHistory;
	}

	public void setPatientMedHistory(PatientMedicalHistory patientMedHistory) {
		this.patientMedHistory = patientMedHistory;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientfirstName=" + patientfirstName + ", patientlastName=" + patientlastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", dateOfBirth=" + dateOfBirth + ", ssn=" + ssn
				+ ", patientMedHistory=" + patientMedHistory + "]";
	}

}
