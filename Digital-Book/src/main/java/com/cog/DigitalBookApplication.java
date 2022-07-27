package com.cog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class DigitalBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookApplication.class, args);
	
		System.out.println("Digital-Book Start");
	}

}
