package com.ravi.boot.PatientApplication.menu;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MainMenu {

	private static Logger logger=LoggerFactory.getLogger(MainMenu.class);
	public MainMenu() {
	}

	public void init() {
		System.out.println("1) Patients \n" + "2) Appointments \n" + 
	"3) Reports \n" + "4) Exit");

		System.out.print("Selection: ");
		try (Scanner input = new Scanner(System.in)) {

			switch (input.nextInt()) {
			case 1:
				System.out.println("You selected Patients \n");
				new PatientMenu().init();;
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
