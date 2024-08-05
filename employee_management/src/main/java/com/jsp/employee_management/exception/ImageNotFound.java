package com.jsp.employee_management.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImageNotFound extends RuntimeException {
	String msg;

	public ImageNotFound(String msg) {
		super();
		this.msg = msg;
	}
	

}
