 package com.cog.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<?>exceptionHandler(StudentNotFound e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
																		 HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>("please change http method type",HttpStatus.BAD_REQUEST);
	}
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object>body=new HashMap<>();
		
		List<String>errors=ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(e ->e.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("Errors", errors);
		return new ResponseEntity<Object>(body,status);
	}
	
}
