package com.example.bank_coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BankCodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCodingApplication.class, args);
	}

}
