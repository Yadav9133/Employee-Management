package com.jsp.employee_management.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class IdNotFound extends RuntimeException {
	
	//String msg="user not foundS";
      String msg="Id not found";
	public IdNotFound(String msg) {
		super();
		this.msg = msg;
	}

}
