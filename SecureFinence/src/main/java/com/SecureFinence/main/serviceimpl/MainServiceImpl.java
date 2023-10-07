package com.SecureFinence.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecureFinence.main.model.Enquiry;
import com.SecureFinence.main.repository.EnquiryRepository;
import com.SecureFinence.main.service.MainService;
@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	EnquiryRepository er;

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

}
