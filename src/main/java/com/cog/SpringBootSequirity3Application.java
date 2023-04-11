package com.cog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSequirity3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSequirity3Application.class, args);

        System.out.println("Application Start !!!! OO");
    }


}
