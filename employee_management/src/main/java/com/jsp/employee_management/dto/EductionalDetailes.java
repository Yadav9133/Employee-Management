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
public class EductionalDetailes {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int studentId;
	  private String name;
	  private String degree;
	  private int ypassout;
	
	  
	  public EductionalDetailes(String name, String degree, int ypassout) {
		super();
		this.name = name;
		this.degree = degree;
		this.ypassout = ypassout;
	}
	  
	  
	  
}
