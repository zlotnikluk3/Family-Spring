package com.FamilyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FamilyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyAppApplication.class, args);
	}

}
