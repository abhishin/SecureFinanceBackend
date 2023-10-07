package com.SecureFinence.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.SecureFinence.main.model.Customer;

public interface CustomerService {

	public void saveCustomer(String customerprofile, String customerpaddr, String customerladdr, String bankDetails,
			MultipartFile panimg, MultipartFile aadimg, MultipartFile profileimgimg, MultipartFile signimg,
			MultipartFile salaryslipimg, MultipartFile statement, MultipartFile quationdoc, MultipartFile form16g,
			MultipartFile itrDoc);

	
	

}
