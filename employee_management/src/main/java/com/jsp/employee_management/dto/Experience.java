package com.jsp.employee_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
	
	@Id
	private int empid;
	private String companyName;
	private int yearsExp;
	private String role;
	

}
