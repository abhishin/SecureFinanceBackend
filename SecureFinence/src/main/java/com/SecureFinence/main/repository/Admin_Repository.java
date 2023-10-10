package com.SecureFinence.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.SecureFinence.main.model.Employee;

public interface Admin_Repository extends CrudRepository<Employee, Integer> {

}
