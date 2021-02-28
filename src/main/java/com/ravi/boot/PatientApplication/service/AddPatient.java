package com.ravi.boot.PatientApplication.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ravi.boot.PatientApplication.enums.AffectedOrgan;
import com.ravi.boot.PatientApplication.enums.Gender;
import com.ravi.boot.PatientApplication.menu.MainMenu;
import com.ravi.boot.PatientApplication.model.Patient;
import com.ravi.boot.PatientApplication.model.PatientMedicalHistory;
import com.ravi.boot.PatientApplication.repository.PatientRepository;

@Service
public class AddPatient {

	
	
	private static Logger logger = LoggerFactory.getLogger(AddPatient.class);

	
	public AddPatient() {
	}

	public void init() {
		Scanner sc = new Scanner(System.in);

		Patient patient = new Patient();
		System.out.print("Enter Patient First Name: ");
		String firstName = sc.nextLine();
		firstName = validateName(sc, firstName);
		System.out.print("\nEnter Patient Last Name: ");
		String lastName = sc.nextLine();
		lastName = validateName(sc, lastName);
		System.out.print("\nEnter Email Id: ");
		/*
		 * String email = sc.nextLine(); while (!isValidEmail(email)) {
		 * System.out.println("Please Enter Valid Email ID!! ");
		 * System.out.print("Please try again : "); email = sc.nextLine(); }
		 */
		System.out.print("\nEnter Phone Number: ");
		/*
		 * String phoneNumber = sc.nextLine(); while (!isValidPhoneNumber(phoneNumber))
		 * { System.out.println("Please Enter Valid Phone Number!! ");
		 * System.out.print("Please try again : "); phoneNumber = sc.nextLine(); }
		 */
		System.out.print("Enter City: ");
		String city = sc.nextLine();
		city = validateCityState(sc, city, true);

		System.out.print("Enter State: ");
		String state = sc.nextLine();
		state = validateCityState(sc, state, false);

		System.out.print("Enter Date of birth(MM/DD/YYYY): ");
		/*
		 * String dateOfBirth = sc.nextLine(); while (!validateDob(dateOfBirth)) {
		 * System.out.println("Please Enter Valid DOB (MM/DD/YYYY)!! ");
		 * System.out.print("Please try again : "); dateOfBirth = sc.nextLine(); }
		 */
		System.out.print("Enter Gender (M/F): ");
		String gender = sc.nextLine();
		boolean genderflag = false;
		while (!genderflag) {
			if (Gender.MALE.getGender().equalsIgnoreCase(gender)) {
				gender = Gender.MALE.name();
				genderflag = true;
			} else if (Gender.FEMALE.getGender().equalsIgnoreCase(gender)) {
				gender = Gender.FEMALE.name();
				genderflag = true;
			} else {
				System.out.println("Please Enter Valid Gender!! ");
				System.out.print("Please try again : ");
				gender = sc.nextLine();
				genderflag = false;
			}
		}

		System.out.print("Enter Height: ");
		String height = sc.nextLine();
		while (!validateNum(height)) {
			System.out.println("Please Enter Valid Height!! ");
			System.out.print("Please try again : ");
			height = sc.nextLine();
		}

		System.out.print("Enter Weight: ");
		String weight = sc.nextLine();
		while (!validateNum(weight)) {
			System.out.println("Please Enter Valid Weight!! ");
			System.out.print("Please try again : ");
			weight = sc.nextLine();
		}

		System.out.print("Enter Pulse Rate: ");
		String pr = sc.nextLine();
		while (!validateNum(pr)) {
			System.out.println("Please Enter Valid Pulse rate!! ");
			System.out.print("Please try again : ");
			pr = sc.nextLine();
		}

		System.out.print("Enter Blood Pressure: ");
		String bloodPressure = sc.nextLine();
		while (!validateNum(bloodPressure)) {
			System.out.println("Please Enter Valid Blood Pressure!! ");
			System.out.print("Please try again : ");
			bloodPressure = sc.nextLine();
		}

		System.out
				.print("Enter affected organ number :" + "LUNGS(1), HEART(2), LEG(3), HANDS(4), KIDNEY(5),OTHERS(6) ");
		int affectedOrgan = sc.nextInt();
		String affectedOrganName = "";
		boolean affectedOrganflag = false;
		while (!affectedOrganflag) {
			if (AffectedOrgan.LUNGS.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.LUNGS.name();
				affectedOrganflag = true;
			} else if (AffectedOrgan.HEART.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.HEART.name();
				affectedOrganflag = true;
			} else if (AffectedOrgan.LEG.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.LEG.name();
				affectedOrganflag = true;
			} else if (AffectedOrgan.KIDNEY.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.KIDNEY.name();
				affectedOrganflag = true;
			} else if (AffectedOrgan.HANDS.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.HANDS.name();
				affectedOrganflag = true;
			} else if (AffectedOrgan.OTHERS.getOrgan() == affectedOrgan) {
				affectedOrganName = AffectedOrgan.OTHERS.name();
				affectedOrganflag = true;
			} else {
				System.out.println("Please Enter Valid Affected Organ Number!! ");
				System.out.print("Please try again : ");
				affectedOrgan = sc.nextInt();
				affectedOrganflag = false;
			}
		}

		patient.setPatientfirstName(firstName);
		patient.setPatientlastName(lastName);
		//patient.setEmail(email);
		//patient.setPhoneNumber(phoneNumber);
		patient.setCity(city);
		patient.setState(state);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
		//patient.setDateOfBirth(dob);
		patient.setGender(gender);
		PatientMedicalHistory pateintMedicalHistory = new PatientMedicalHistory();
		pateintMedicalHistory.setHeight(Double.parseDouble(height));
		pateintMedicalHistory.setWeight(Double.parseDouble(weight));
		pateintMedicalHistory.setPulseRate(Double.parseDouble(pr));
		pateintMedicalHistory.setBloodPressure(Double.parseDouble(bloodPressure));
		pateintMedicalHistory.setAffectedOrgan(affectedOrganName);
		patient.setPatientMedHistory(pateintMedicalHistory);

		System.out.println(patient.toString());
		signup(patient);
	}

	private boolean validateNum(String height) {
		try {
			Double.parseDouble(height);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private String validateName(Scanner sc, String name) {
		while (name.length() < 5) {
			System.out.println("Name must be atleast 5 character in length !! ");
			System.out.print("Please try again : ");
			name = sc.nextLine();
		}
		return name;
	}

	private String validateCityState(Scanner sc, String attribute, boolean flag) {
		while (attribute.length() < 3) {
			if (flag)
				System.out.println("City must be atleast 3 character in length !! ");
			else
				System.out.println("State must be atleast 3 character in length !! ");
			System.out.print("Please try again : ");
			attribute = sc.nextLine();
		}
		return attribute;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidPhoneNumber(String number) {
		String phoneNumRegex = "^(\\d{3}[- .]?){2}\\d{4}$";
		Pattern pat = Pattern.compile(phoneNumRegex);
		if (number == null)
			return false;
		return pat.matcher(number).matches();
	}

	public static boolean validateDob(String dob) {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(dob);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public void signup(Patient patient) {
		PatientService patientService=new PatientService();
		Patient savedPatient=patientService.save(patient);
		System.out.println("Patient is Registered!! \n" +savedPatient);
	//	new MainMenu();
	}

}
