package com.techstuff.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
		System.out.println("first");
		System.out.println("second");
		System.out.println("fourth");
		System.out.println("third");
	}
}
