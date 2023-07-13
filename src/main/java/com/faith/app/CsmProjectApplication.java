package com.faith.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CsmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsmProjectApplication.class, args);
		System.out.println(" Rahala WELCOME to  CMS  project ");
	}

}
