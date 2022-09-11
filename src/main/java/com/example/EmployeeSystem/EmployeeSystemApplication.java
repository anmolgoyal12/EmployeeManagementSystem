package com.example.EmployeeSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EmployeeSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApplication.class, args);
		System.out.println("###### Employee Management System Application started at port 8080 ######");
	}

}
