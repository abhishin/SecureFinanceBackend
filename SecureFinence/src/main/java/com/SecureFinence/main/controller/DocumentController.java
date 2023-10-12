package com.SecureFinence.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SecureFinence.main.exeption.EnquiryNotFoundException;
import com.SecureFinence.main.model.CustomerDocuments;
import com.SecureFinence.main.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	

	
	@GetMapping("/getdoc")
	public CustomerDocuments getCustomerDocuments() throws EnquiryNotFoundException {
	Integer docId = 3; // this is hardcoded docID add any id from your docy=ument table
	Optional<CustomerDocuments> document = documentService.getSingleDocument(docId);
	CustomerDocuments customerDocs = null;
	if (document.isPresent()) {
		customerDocs = document.get();

	} else {
		throw new EnquiryNotFoundException("Sorry! Document is not present");
	}
	return customerDocs;
}
}
	
	


