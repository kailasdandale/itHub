package com.cog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class DigitalBookReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookReaderApplication.class, args);
		System.out.println("reserApp");
		System.out.println("Reader Start");
	}
	@Bean
	@LoadBalanced
	public RestTemplate rt() {
		return new RestTemplate();
	}

}
