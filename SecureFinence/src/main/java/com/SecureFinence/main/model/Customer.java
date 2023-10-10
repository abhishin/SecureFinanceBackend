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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String motherName;
	private String dob;
	
	private String email;
	private long adharNumber;
	private long mobileNumber;
	private String pan;
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetails userDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerPermantAddress customerPermantAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerLocalAddress customerLocalAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments customerDocuments;
	
	
	
	

}
