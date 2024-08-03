package com.jsp.employee_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jsp.employee_management.dto.Employee;
import com.jsp.employee_management.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepo repo;

	
	
	public void saveEmp(Employee emp) {
		    
		     repo.save(emp);
	}



	public Employee fetchById(int id) {
		Optional<Employee> db = repo.findById(id);
		
		if(db.isPresent()) {
			
			return db.get();
		}else {
			return null;
		}
		
	}



	public void deleteBy(int id) {
		  repo.deleteById(id);
		 	
	}



	public Employee fetchByEmail(String email) {
		    Employee db = repo.findByEmail(email);
		    if(db!=null) {
		    	db.getEmail();
		    }
		return null;
	}

}
