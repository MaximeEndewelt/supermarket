package com.example.policyexpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.policyexpert")
public class PolicyexpertApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyexpertApplication.class, args);
	}
}
