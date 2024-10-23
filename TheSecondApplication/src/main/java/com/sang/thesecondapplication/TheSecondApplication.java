package com.sang.thesecondapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheSecondApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("Hello, Spring Boot!");
		};
	}
}
