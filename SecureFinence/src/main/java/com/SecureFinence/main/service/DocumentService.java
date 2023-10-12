package com.SecureFinence.main.service;

import java.util.Optional;

import com.SecureFinence.main.model.CustomerDocuments;

public interface DocumentService {

public	Optional<CustomerDocuments> getSingleDocument(Integer docId);

}
