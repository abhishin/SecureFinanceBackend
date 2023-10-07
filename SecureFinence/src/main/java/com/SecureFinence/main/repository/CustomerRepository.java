package com.SecureFinence.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.SecureFinence.main.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
