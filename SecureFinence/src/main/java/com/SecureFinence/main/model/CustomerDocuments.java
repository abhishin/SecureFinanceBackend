package com.SecureFinence.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CustomerDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerDocumentId;
	@Lob
	private byte[] customerPan;
	@Lob
	private byte[] customerAdhar;
	@Lob
	private byte[] customerProfilePhoto;
	@Lob
	private byte[] customerSignature;
	@Lob
	private byte[] customerSalarySlip;
	@Lob
	private byte[] customerBAnkStatement;
	@Lob
	private byte[] customerCarQuotation;
	@Lob
	private byte[] customerForm16;
	@Lob
	private byte[] customerITR;
	

}
