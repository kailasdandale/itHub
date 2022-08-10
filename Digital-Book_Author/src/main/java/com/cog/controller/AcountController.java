//package com.cog.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cog.model.Author;
//import com.cog.services.AuthorService;
//@RestController
//@CrossOrigin("*")
//public class AcountController {
//	
//	@Autowired
//	private AuthorService aservice;
//	
//	@PostMapping("/sinup")
//	public  ResponseEntity<Author>createAccount(@RequestBody Author author){
//		return new ResponseEntity<Author>
//		(aservice.createAccount(author),HttpStatus.CREATED);
//	}
//}
