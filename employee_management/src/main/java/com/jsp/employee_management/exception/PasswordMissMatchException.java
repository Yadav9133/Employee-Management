package com.jsp.employee_management.exception;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class PasswordMissMatchException extends RuntimeException{
   String msg="Password MissMatch";

public PasswordMissMatchException(String msg) {
	super();
	this.msg = msg;
}
   
   
}
