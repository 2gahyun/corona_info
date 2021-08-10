package com.greenart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoronaInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaInfoServiceApplication.class, args);
	}

}
