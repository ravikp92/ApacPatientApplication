package com.ravi.boot.PatientApplication.config;
import java.sql.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.ravi.boot.PatientApplication.PatientApplication; 

public class GenericDAO {

	private static final Logger logger = LoggerFactory.getLogger(PatientApplication.class);
private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver"; 
	private static final String CONNECTION_STRING="jdbc:mysql://127.0.0.1:3306/patientportal?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT";
	private static final String USERNAME="root"; 
	private static final String PASSWORD="password_123"; 
	
	Connection con=null;
	 
	public GenericDAO() {
		
		con=getConnection();
	}
	
	public Connection getConnection() {
		
		if(con==null) {
		try{  
			Class.forName(DRIVER_CLASS);  
			con=DriverManager.getConnection(  
					CONNECTION_STRING,USERNAME,PASSWORD);  
			  
			}catch(Exception e){
				logger.error(e.getMessage());
				}  
		
		}
		return con;
	}
	
	
	
}
