package com.SecureFinence.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.model.Customer;
import com.SecureFinence.main.repository.CustomerRepository;
import com.SecureFinence.main.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository cr;
	

	@Override
	public Customer save(String cUSj, MultipartFile panimg, MultipartFile aadimg, MultipartFile profileimgimg,
			MultipartFile signimg, MultipartFile salaryslipimg, MultipartFile statement, MultipartFile quationdoc,
			MultipartFile form16g, MultipartFile itrDoc) {
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			Customer customer=mapper.readValue(cUSj, Customer.class);
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
		
		
		
		
		return null;
		
		
		
		
	}

}
