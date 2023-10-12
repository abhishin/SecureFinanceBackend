package com.SecureFinence.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecureFinence.main.model.CustomerDocuments;
import com.SecureFinence.main.repository.DocumentRepository;
import com.SecureFinence.main.service.DocumentService;
@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	DocumentRepository documentRepository;

	@Override
	public Optional<CustomerDocuments> getSingleDocument(Integer docId) {
		
		return documentRepository.findById(docId);
	}

}
