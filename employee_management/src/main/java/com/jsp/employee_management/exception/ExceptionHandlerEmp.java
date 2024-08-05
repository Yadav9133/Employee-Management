package com.jsp.employee_management.exception;



import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.jsp.employee_management.util.ResponseStructure;



@RestControllerAdvice
public class ExceptionHandlerEmp {

	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlIntegrity(SQLIntegrityConstraintViolationException exception) {
	          
		ResponseStructure<String> r=new ResponseStructure<String>();
		  
		r.setData(exception.getMessage());
		r.setStatusCode(HttpStatus.BAD_REQUEST.value());
		r.setMsg("can't perform the operation..");
		
	return new ResponseEntity<ResponseStructure<String>>(r,HttpStatus.BAD_REQUEST);
		
		//we got rise email not found and pwd mismatch exception...
	}
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFound excep){
		 
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(excep.getMessage());
		rs.setMsg("can't perform the operation..");
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
 		
	}
	
	@ExceptionHandler(PasswordMissMatchException.class)
	public ResponseEntity<ResponseStructure<String>> passwordMissMatch(PasswordMissMatchException pwd){
		
		   ResponseStructure<String> rs=new ResponseStructure<String>();
		   rs.setData(pwd.getMessage());
		   rs.setMsg("can't perform the operation..");
		   rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> passwordMissMatch(EmailNotFoundException pwd){
		
		   ResponseStructure<String> rs=new ResponseStructure<String>();
		   rs.setData(pwd.getMessage());
		   rs.setMsg("can't perform the operation..");
		   rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ImageNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ImageNotFound(EmailNotFoundException pwd){
		
		   ResponseStructure<String> rs=new ResponseStructure<String>();
		   rs.setData(pwd.getMessage());
		   rs.setMsg("can't perform the operation..");
		   rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
	return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
	}
}
