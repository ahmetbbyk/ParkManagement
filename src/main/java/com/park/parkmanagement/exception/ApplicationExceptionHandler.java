package com.park.parkmanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@ExceptionHandler(value = { ParkingException.class })
	public ResponseEntity<Object> handleBusinessException(ParkingException ex) {

		logger.error("Business Exception: " + ex.getCode().getExcCode() + " " +ex.getCode().getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {

		logger.error("Exception: " + ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}