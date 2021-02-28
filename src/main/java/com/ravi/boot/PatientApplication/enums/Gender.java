package com.ravi.boot.PatientApplication.enums;

public enum Gender {
	  MALE("M"),FEMALE("F");

	private String gender; 
	  
    // getter method 
    public String getGender() 
    { 
        return this.gender; 
    } 
  
    // enum constructor - cannot be public or protected 
    private Gender(String gender) 
    { 
        this.gender = gender; 
    } 
}
