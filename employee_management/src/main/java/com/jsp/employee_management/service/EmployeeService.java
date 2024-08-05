package com.jsp.employee_management.service;

import java.io.IOException;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.employee_management.dao.EmployeeDao;
import com.jsp.employee_management.dto.Employee;
import com.jsp.employee_management.entity.EmpClone;
import com.jsp.employee_management.exception.EmailNotFoundException;
import com.jsp.employee_management.exception.IdNotFound;
import com.jsp.employee_management.exception.ImageNotFound;
import com.jsp.employee_management.exception.PasswordMissMatchException;
import com.jsp.employee_management.util.ResponseStructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	JavaMailSender mailsender;

	
	//in this layer if data is not prasent raise the exception...not done yet...


	public ResponseEntity<ResponseStructure<Employee>> fetchByEmailAndPwd(String email, String pwd) throws AddressException, MessagingException {
	
		    Employee db = dao.fetchByEmail(email); 
		    
		       if(db!=null) {
		    	   if(db.getPwd().equals(pwd)) {
		    		    ResponseStructure<Employee> rs=new ResponseStructure<Employee>();
		    			
		    			rs.setMsg("login successfully done...");
		    			rs.setData(db);
		    		   
		    		    MimeMessage message = mailsender.createMimeMessage();
		    		   // message.setFrom(new InternetAddress("vittalyadav8328@gmail.com"));
		    		    message.setRecipients(MimeMessage.RecipientType.TO, db.getEmail());
		    		    message.setSubject("This mail is from Vitthal Rao");
		    		    String htmlContent = "<h1>You are login is successfull..</h1><img src=\"https://template.canva.com/EAFhV_byuNw/1/0/311w-QF1wi5PupMc.jpg\">" +   
		    		                         " <p>Happy <strong>Freind-ship</strong> Day.</p>";
		    		    message.setContent(htmlContent, "text/html; charset=utf-8");
		    		    mailsender.send(message);
		    		    rs.setStatusCode(HttpStatus.ACCEPTED.value());
		    			
		    	    return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.ACCEPTED);
		    		 
		    	   }else {
		    		   throw new PasswordMissMatchException("entered password wrong enter the right pwd:");
		    	   }
		       }else {
		    	   
		    	    throw new EmailNotFoundException("enter the right email.."+email);
		    	        
		       }
	}


	public ResponseEntity<ResponseStructure<EmpClone>> deleteById(int id) {
		       Employee db = dao.fetchById(id);
		       if(db!=null) {
		    	   dao.deleteBy(id);
		    	   ResponseStructure<EmpClone> rs=new ResponseStructure<EmpClone>();
		    	   
		    	   rs.setStatusCode(HttpStatus.ACCEPTED.value());
		    	   rs.setMsg("data has been deleted successfully...");
		    	   rs.setData(mapper.map(db, EmpClone.class));
		    	   
		    	   return new ResponseEntity<ResponseStructure<EmpClone>>(rs,HttpStatus.ACCEPTED);
		       }else {
		    	   throw new IdNotFound("Id is not found while deleteting pls enter right id:"+id);
		       }
		
	}


	public ResponseEntity<ResponseStructure<EmpClone>> saveImage(int id, MultipartFile file) throws IOException {
		      Employee emp = dao.fetchById(id); 
		      if(emp!=null) {
		    	  emp.setImage(file.getBytes());
		    	  dao.UpdatedById(emp);
		    	  ResponseStructure<EmpClone> rs=new ResponseStructure<EmpClone>();
		    	   
		    	   rs.setStatusCode(HttpStatus.ACCEPTED.value());
		    	   rs.setMsg("Image has been updated successfully...");
		    	   rs.setData(mapper.map(emp, EmpClone.class));
		    	   
		       return new ResponseEntity<ResponseStructure<EmpClone>>(rs,HttpStatus.ACCEPTED);
		      }else {
		    	  throw new IdNotFound("User id is not Found:"+id);
		      }
		

	}


	public ResponseEntity<byte[]> fetchImage(int id) {
		       Employee db = dao.fetchById(id); 
		       if(db!=null) {
		    	   byte[] img = db.getImage();
                   if(img!=null) {
		    	      HttpHeaders headers = new HttpHeaders(); 
		    	                  headers.setContentType(MediaType.IMAGE_JPEG);
		    	       return new ResponseEntity<byte[]>(img,headers,HttpStatus.FOUND);
		    	   
		    	   }else 
		    		   throw new ImageNotFound("image object is empty");
		    		   
		    	   
		       }else 
		    		 throw new IdNotFound("User id is not Found:"+id);  
	            
	}

	
	

}
