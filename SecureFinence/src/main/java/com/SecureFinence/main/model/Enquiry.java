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
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId;
	private String customerName;
	private String pancardNumber;
	private String customerMobileNumber;
	private String customerAlternateMobileNumber;
	private String customerEmailId;
	private String customerDateOfBirth;
	private String enquiryStatus;
	@OneToOne(cascade = CascadeType.ALL)
	private CibilScore cibilScore;

}
