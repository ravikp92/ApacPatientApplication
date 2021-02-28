package com.ravi.boot.PatientApplication.menu;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ravi.boot.PatientApplication.service.AddPatient;

public class PatientMenu {

	private static Logger logger=LoggerFactory.getLogger(PatientMenu.class);
	public PatientMenu() {
	}

	public void init() {
		System.out.println("1) Add Patient \n" + "2) Update Patient \n" + "3) "
				+ "Delete Patient \n" + "4) Search Patient \n" + "5) Exit ");

		System.out.print("Selection: ");
		try (Scanner input = new Scanner(System.in)) {

			switch (input.nextInt()) {
			case 1:
				new AddPatient().init();
				break;
			case 2:
				System.out.println("You picked option 2");
				break;
			case 3:
				System.out.println("You picked option 3");
				break;
			default:
				System.err.println("Unrecognized option");
				break;
			}
		} catch (Exception e) {
			logger.error("Expcetion occured at Main Menu class {0}"+e);
		}
	}
}
