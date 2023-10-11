package com.SecureFinence.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private	 int   employeeId;
private	String  employeeName;
private	String  employeeAdress;
private	Long  employeeNumber;
private	String  employeeEmail;
private	String  employeeRole;



@OneToOne(cascade = CascadeType.ALL) 
private EmployeeDocuments documents;
	
	
	

}
