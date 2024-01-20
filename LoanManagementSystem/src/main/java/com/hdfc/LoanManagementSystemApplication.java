package com.hdfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hdfc.serviceImpl.RefNumberGenerator;

@SpringBootApplication
public class LoanManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemApplication.class, args);
	}

}
