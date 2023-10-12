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
public class EmployeeDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeDocumentId;
	@Lob
	private byte[] employeePan;
	@Lob
	private byte[] employeeAdhar;
	@Lob
	private byte[] employeeProfilePhoto;
	@Lob
	private byte[] employeeSignature;
	

}
