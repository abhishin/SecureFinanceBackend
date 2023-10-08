package com.SecureFinence.main.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.model.Customer;
import com.SecureFinence.main.model.CustomerBankDetails;
import com.SecureFinence.main.model.CustomerDocuments;
import com.SecureFinence.main.model.CustomerLocalAddress;
import com.SecureFinence.main.model.CustomerPermantAddress;
import com.SecureFinence.main.repository.CustomerRepository;
import com.SecureFinence.main.service.CustomerService;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	

	@Override
	public void saveCustomer(String customerprofile, String customerpaddr, String customerladdr, String bankDetails,
			MultipartFile panimg, MultipartFile aadimg, MultipartFile profileimgimg, MultipartFile signimg,
			MultipartFile salaryslipimg, MultipartFile statement, MultipartFile quationdoc, MultipartFile form16g,
			MultipartFile itrDoc) {
		ObjectMapper mapper= new ObjectMapper();
		
		try {
			Customer customer=mapper.readValue(customerprofile, Customer.class);
			
			CustomerPermantAddress customerPermantAddress=mapper.readValue(customerpaddr, CustomerPermantAddress.class);
			
			CustomerLocalAddress customerLocalAddress=mapper.readValue(customerladdr, CustomerLocalAddress.class);
			CustomerBankDetails customerBankDetails =mapper.readValue(bankDetails, CustomerBankDetails.class);
//			
//			customer.setCustomerPermantAddress(customerPermantAddress);
//			customer.setCustomerLocalAddress(customerLocalAddress);
//			customer.setCustomerBankDetails(customerBankDetails);
			
			CustomerDocuments customerDocuments=new CustomerDocuments();
			
//			customerDocuments.setCustomerAdhar(aadimg.getBytes());
//			customerDocuments.setCustomerBAnkStatement(statement.getBytes());
//			customerDocuments.setCustomerCarQuotation(quationdoc.getBytes());
//			customerDocuments.setCustomerForm16(form16g.getBytes());
//			customerDocuments.setCustomerITR(itrDoc.getBytes());
//			customerDocuments.setCustomerPan(panimg.getBytes());
//			customerDocuments.setCustomerProfilePhoto(panimg.getBytes());
//			customerDocuments.setCustomerSalarySlip(salaryslipimg.getBytes());
//			customerDocuments.setCustomerSignature(signimg.getBytes());
//			
//			customer.setCustomerDocuments(customerDocuments);
			
			customerRepository.save(customer);
			
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	
		
				
		
		
		
		
		

}
