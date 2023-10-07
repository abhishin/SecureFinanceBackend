package com.SecureFinence.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.model.Customer;
import com.SecureFinence.main.service.CustomerService;

@RestController

public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save_customer")
	public ResponseEntity<Customer> savecus(
			@RequestPart(name="cusJson",required = true) String CUSj,
			@RequestPart(name ="cPan",required = true) MultipartFile panimg,
			@RequestPart(name ="adhar",required = true) MultipartFile aadimg,
			@RequestPart(name ="profile",required = true) MultipartFile profileimgimg,
			@RequestPart(name ="sign",required = true) MultipartFile signimg,
			@RequestPart(name ="salaryslip",required = true) MultipartFile salaryslipimg,
			@RequestPart(name ="bankstatement",required = true) MultipartFile statement,
			@RequestPart(name ="quation",required = true) MultipartFile quationdoc,
			@RequestPart(name ="form16",required = true) MultipartFile form16g,
			@RequestPart(name ="itr",required = true)MultipartFile itrDoc){
		
		Customer cus =customerService.save(CUSj,panimg,aadimg,profileimgimg,signimg,salaryslipimg,statement
				,quationdoc,form16g,itrDoc);
		
		
		return new ResponseEntity<Customer>(cus, HttpStatus.CREATED);
		
	}
	

}
