package com.SecureFinence.main.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EnquiryNotFoundException.class)
	public ResponseEntity<String> productNotFoundExceptionHandled(EnquiryNotFoundException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
