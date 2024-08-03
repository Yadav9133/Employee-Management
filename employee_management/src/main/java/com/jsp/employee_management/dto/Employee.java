package com.jsp.employee_management.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Component
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long phn;
	@Column(unique=true)
	private String email;
	private String pwd;
	private String dob;
	@Lob
	@Column(columnDefinition = "LONGBLOB",length=999)
	private byte[] image;
	@OneToMany(cascade=CascadeType.ALL)
	List<Experience> exp;	
	@OneToMany(cascade=CascadeType.ALL)
	List<EductionalDetailes> detailes;
	
	
}
