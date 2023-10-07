package com.SecureFinence.main.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Email {
	
	private String toMail;
	private String fromMail;
	private String Subject;
	private byte[] attachment;

}
