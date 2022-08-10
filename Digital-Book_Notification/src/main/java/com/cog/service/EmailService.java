package com.cog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cog.model.EmailEntity;

@Service
public class EmailService {

	@Autowired
	JavaMailSender sender;
	
	public void sendEmail(EmailEntity e) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(e.getToEmail());
		msg.setFrom(e.getFormEmail());
		msg.setText(e.getMsg());
		msg.setSubject(e.getSubject());
		
		sender.send(msg);
		System.out.println("send");
		
	}

}
