package com.calculation.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleException(RuntimeException e){
		e.printStackTrace();
		
		return ResponseEntity
				.internalServerError()
				.build();
	}
}
