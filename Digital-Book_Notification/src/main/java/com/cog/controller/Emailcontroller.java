package com.cog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.model.EmailEntity;
import com.cog.service.EmailService;

@RestController
public class Emailcontroller {

	@Autowired
	private EmailService esvice;
	
	@Value("${spring.mail.username}")
	private String formEmail;
	@PostMapping("/emailsend")
	public String sendEmail(@RequestBody EmailEntity e){
		
		e.setFormEmail(formEmail);
		try {
			
			esvice.sendEmail(e);
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		return "email can not send";
	}
}
