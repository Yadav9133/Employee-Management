package com.jsp.employee_management.exception;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Data
public class EmailNotFoundException extends RuntimeException {
	
	String msg="Email Not Found";

	public EmailNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
