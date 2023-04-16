package com.example.springBootAssesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springBootAssesment.service.UserService;


@SpringBootApplication
public class SpringBootAsssesmentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootAsssesmentApplication.class, args);
		System.out.println("Ready");

//		UserService userService = context.getBean(UserService.class);
	}

}
