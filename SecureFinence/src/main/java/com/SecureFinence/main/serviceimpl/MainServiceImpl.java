package com.SecureFinence.main.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.model.Employee;
import com.SecureFinence.main.model.EmployeeDocuments;
import com.SecureFinence.main.model.Enquiry;
import com.SecureFinence.main.model.UserDetails;
import com.SecureFinence.main.repository.Admin_Repository;
import com.SecureFinence.main.repository.Employee_Repository;
import com.SecureFinence.main.repository.EnquiryRepository;
import com.SecureFinence.main.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	EnquiryRepository er;
	
	@Autowired
	Admin_Repository ad;
	
	@Autowired
	Employee_Repository err;

	@Override
	public void saveEnquiry(Enquiry en) {
		er.save(en);
		
		
	}

	@Override
	public List<Enquiry> getAllEnquiry() {
		// TODO Auto-generated method stub
		return (List<Enquiry>) er.findAll();
	}

	@Override
	public Optional<Enquiry> getSingleEnquiry(int enquiryId) {
		Optional<Enquiry> enquiryData = er.findById(enquiryId);

		return enquiryData;
	}

	@Override
	public void saveEnquiryObject(Enquiry enquiryObject) {
		er.save(enquiryObject);
		
	}
///////////////////////////////////admin crud//////////////////////////////////////////////////
	

	@Override
	public List<Employee> getemployee() {
		
		return (List<Employee>) ad.findAll();
	}

	@Override
	public void deleteemployee(int i) {
		ad.deleteById(i);
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

	@Override
	public Employee saveEmployee(String employeeprofile, MultipartFile panimg, MultipartFile aadimg,
			MultipartFile profileimg, MultipartFile signimg) {
ObjectMapper mapper= new ObjectMapper();
		
		try {
			Employee employee=mapper.readValue(employeeprofile, Employee.class);
			
					
			EmployeeDocuments empdocs=new EmployeeDocuments();
			try {
				empdocs.setEmployeeAdhar(aadimg.getBytes());
				empdocs.setEmployeePan(panimg.getBytes());
				empdocs.setEmployeeProfilePhoto(employeeprofile.getBytes());
				empdocs.setEmployeeSignature(signimg.getBytes());
				employee.setDocuments(empdocs);
			
				
				
			return	err.save(employee);
				
			} catch (IOException e) {
		
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
