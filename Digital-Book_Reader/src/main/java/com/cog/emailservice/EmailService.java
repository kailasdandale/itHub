package com.cog.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cog.model.EmailEntity;
import com.cog.model.Reader;
import com.cog.repository.ReaderRepo;
import com.cog.service.ReaderService;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	
	
	@Value("${spring.mail.username}")
	private String formEmail;

	
	public void sendEmailreader(String email) {

		System.out.println("Email service :"+email+"+"+formEmail);
		EmailEntity e=new EmailEntity();
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(email);
		msg.setFrom(formEmail);
		msg.setText("thank you for choose this book");
		msg.setSubject(" Susscribe book");
		sender.send(msg);
		System.out.println("send");
//		return "send";
		//e.setFormEmail(formEmail);
//		try {
//
//			sendEmail(email);
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//		return "email can not send";
	}
	
	public void sendEmail(String email) {
		
		EmailEntity e=new EmailEntity();
	
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(email);
		msg.setFrom(formEmail);
		msg.setText("thank you for choose this book");
		msg.setSubject(" Susscribe book");
		sender.send(msg);
		System.out.println("send");
		
	}
}
