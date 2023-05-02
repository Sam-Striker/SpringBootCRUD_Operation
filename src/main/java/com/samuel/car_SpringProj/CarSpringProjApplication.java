package com.samuel.car_SpringProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CarSpringProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSpringProjApplication.class, args);
	}

}
