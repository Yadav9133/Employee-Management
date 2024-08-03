package com.jsp.employee_management.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Employee;
import com.jsp.employee_management.entity.EmpClone;
import com.jsp.employee_management.util.ResponseStructure;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<EmpClone>> saveEmp(@RequestBody Employee emp){
	       
		
		   ResponseStructure<EmpClone> rs=new ResponseStructure<EmpClone>();
		       
		   rs.setStatusCode(HttpStatus.CREATED.value());
		   rs.setMsg("Data has been saved successfully..");
		   
		   dao.saveEmp(emp);
	       EmpClone empclone = mapper.map(emp, EmpClone.class);
	       rs.setData(empclone);
     
		   	 	
	return  new ResponseEntity<ResponseStructure<EmpClone>>(rs,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Employee>> fetchById(@RequestParam int id){
		ResponseStructure<Employee> rs=new ResponseStructure<Employee>();
		
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMsg("data has been fetched successfully...");
		
		
		//EmpClone fetch = mapper.map(id, EmpClone.class);
		rs.setData(dao.fetchById(id));
		
		
   return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/delete1")
	public void deleteByid(@RequestParam int id) {
//		ResponseStructure<Employee> rs=new ResponseStructure<Employee>();
//		rs.setMsg("data has been deleted..");
//		rs.setStatusCode(HttpStatus.FOUND.value());
		
		dao.deleteBy(id);
		
	}
	
	
	public void login(@RequestAttribute String email,String pwd) {
		
		Employee e=new Employee();
		
		dao.fetchByEmail(email);
		
		if(email.equals(e.getEmail()) && pwd.equals(e.getPwd())) {
			System.out.println("login has been successfull...");
		}else {
			System.out.println("enter the right credentials...uuuuuuu");
		}
		
	}

}
