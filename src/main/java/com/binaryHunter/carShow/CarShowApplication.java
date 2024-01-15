package com.binaryHunter.carShow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//combination of other notations
//@EnableAutoConfiguration //will detect your dependencies based on your dependencies
//@ComponentScan //This enables the Spring Boot ComponentScan to find all components in the app
//@Configuration //This annotation is used to define a configuration class that provides beans to the Spring app
@SpringBootApplication
public class CarShowApplication {
private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("Application started");
	}

}
