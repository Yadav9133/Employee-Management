package com.jsp.employee_management.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Employee;
import com.jsp.employee_management.entity.EmpClone;
import com.jsp.employee_management.exception.IdNotFound;
import com.jsp.employee_management.service.EmployeeService;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	EmployeeService service;
	
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
		Employee db = dao.fetchById(id);
		if(db!=null) {
		ResponseStructure<Employee> rs=new ResponseStructure<Employee>();
		
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMsg("data has been fetched successfully...");
		rs.setData(db);
		
		
    return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.FOUND);
		}
		else
			
			throw new IdNotFound("the given id must be wrong enter the right id:"+id);
			
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<EmpClone>> deleteByid(@RequestParam int id) {
		
		return service.deleteById(id);
		
	}
	
	
	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Employee>> login(@RequestParam String email,String pwd) throws AddressException, MessagingException {
		
	return 	service.fetchByEmailAndPwd(email,pwd);
		
	}
	@PutMapping("/saveimage")
	public ResponseEntity<ResponseStructure<EmpClone>> imageUpdateById(@RequestParam int id,@RequestBody MultipartFile file) throws IOException{
		   
		return service.saveImage(id,file);
	}
	@GetMapping("/fetchimage")
	public ResponseEntity<byte[]> fetchImageById(@RequestParam int id){
		return service.fetchImage(id);
		
	}

}
