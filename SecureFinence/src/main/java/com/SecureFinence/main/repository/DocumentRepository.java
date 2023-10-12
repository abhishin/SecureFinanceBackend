package com.SecureFinence.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.SecureFinence.main.model.CustomerDocuments;

public interface DocumentRepository extends JpaRepository<CustomerDocuments, Integer>{

}
