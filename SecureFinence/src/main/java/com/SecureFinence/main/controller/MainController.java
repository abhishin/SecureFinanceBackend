package com.SecureFinence.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.exeption.EnquiryNotFoundException;
import com.SecureFinence.main.model.Employee;
import com.SecureFinence.main.model.Enquiry;
import com.SecureFinence.main.service.CibilScoreGenerator;
import com.SecureFinence.main.service.MainService;

@CrossOrigin(origins = "*")
@RestController
public class MainController {
	@Autowired
	MainService service;

	@Autowired
	CibilScoreGenerator cibilScoreGeneratorService;


	
	
	
	
	
	
	@PostMapping(value = "/postEnquiry")
	public ResponseEntity<Enquiry> saveEnq(@RequestBody Enquiry en){
		
		service.saveEnquiry(en);
		
		return new ResponseEntity<Enquiry>(HttpStatus.CREATED);
		
	}
	

	@GetMapping(value = "/get_Enquiry")
	public ResponseEntity<List<Enquiry>> getEnquiryData(){
		
	List<Enquiry> Alldata =	service.getAllEnquiry();
		
		return new ResponseEntity<List<Enquiry>>( Alldata, HttpStatus.OK);
	}
	
	@PutMapping("/getCibilScore/{enquiryId}")
	public ResponseEntity<Enquiry> getCibilScore(@PathVariable int enquiryId,
			@RequestBody Enquiry enquiryObject) throws EnquiryNotFoundException  {

		// generating cibil and setting other values

		enquiryObject.getCibilScore().setCibilScore(cibilScoreGeneratorService.cibilScoreGenerator(700, 950));
		if (enquiryObject.getCibilScore().getCibilScore() >= 750) {
			enquiryObject.getCibilScore().setCibilRemark("Good");
		} else {
			enquiryObject.getCibilScore().setCibilRemark("Poor");
		}
		// service.saveCibilData(enquiryObject); // updating cibil here
		service.saveEnquiryObject(enquiryObject);
		// getting updated cibil score
		Optional<Enquiry> updatedEnquiryCibilObject = service.getSingleEnquiry(enquiryId);

		Enquiry newEnquiry = null;
		if (updatedEnquiryCibilObject.isPresent()) {
			newEnquiry = updatedEnquiryCibilObject.get();
		} else {
			throw new EnquiryNotFoundException("Sorry! Enquiry is not present");
		}

		return new ResponseEntity<Enquiry>(newEnquiry, HttpStatus.OK);
	}




	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> addemployee(
			@RequestPart(name = "employee", required = true) String empprofile,
			@RequestPart(name = "pan", required = true) MultipartFile panimg,
			@RequestPart(name = "adhar", required = true) MultipartFile aadimg,
			@RequestPart(name = "photo", required = true) MultipartFile profileimg,
			@RequestPart(name = "sign", required = true) MultipartFile signimg

	) {

		Employee e = service.saveEmployee(empprofile, panimg, aadimg, profileimg, signimg);

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getemployee() {
		List<Employee> emplist = service.getemployee();
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK) ;
	}

	@DeleteMapping("/deleteemployee/{i}")
	public String deleteemployee(@PathVariable int i) {

		service.deleteemployee(i);

		return "deleted";
	}

	





}
