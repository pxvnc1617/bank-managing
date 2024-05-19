package com.example.bank_coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.parameters.P;

@EnableJpaAuditing
@SpringBootApplication
public class BankCodingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BankCodingApplication.class, args);
		String [] iocNames = context.getBeanDefinitionNames();
		for (String name : iocNames) {
			System.out.println(name);
		}
	}

}
