package com.jsp.employee_management.util;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	int statusCode;
	String msg;
	T data;
	LocalDateTime time= LocalDateTime.now();

}
