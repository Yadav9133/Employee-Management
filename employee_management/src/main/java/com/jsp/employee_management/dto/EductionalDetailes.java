package com.jsp.employee_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EductionalDetailes {
     
	@Id
	  private int studentId;
	  private String name;
	  private String degree;
	  private int ypassout;
	  
}
