package com.jsp.employee_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String companyName;
	private int yearsExp;
	private String role;
	
	public Experience(String companyName, int yearsExp, String role) {
		super();
		this.companyName = companyName;
		this.yearsExp = yearsExp;
		this.role = role;
	}
	
	
	

}
