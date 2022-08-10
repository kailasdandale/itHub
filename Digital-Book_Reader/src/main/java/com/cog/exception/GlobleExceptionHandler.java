package com.cog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?>handaleException(Exception e){
		
		return null;
	}
}
