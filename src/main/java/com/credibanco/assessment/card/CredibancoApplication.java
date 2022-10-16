package com.credibanco.assessment.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CredibancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredibancoApplication.class, args);
	}

}
