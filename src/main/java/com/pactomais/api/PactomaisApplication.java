package com.pactomais.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PactomaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PactomaisApplication.class, args);
	}

}
