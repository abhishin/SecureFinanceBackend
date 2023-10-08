package com.SecureFinence.main.service;

import java.util.List;
import java.util.Optional;

import com.SecureFinence.main.model.Employee;
import com.SecureFinence.main.model.Enquiry;

public interface MainService {

	public void saveEnquiry(Enquiry en);

	public List<Enquiry> getAllEnquiry();

	public Optional<Enquiry> getSingleEnquiry(int enquiryId);

	public void saveEnquiryObject(Enquiry enquiryObject);

	public void saveemployee(Employee e);

	public List<Employee> getemployee();

	public void deleteemployee(int i);

}
