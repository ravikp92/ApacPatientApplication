package com.ravi.boot.PatientApplication.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PatientFlowException extends Exception 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientFlowException(String exception) {
        super(exception);
    }
}