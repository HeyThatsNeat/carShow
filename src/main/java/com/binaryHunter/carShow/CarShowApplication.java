package com.binaryHunter.carShow;

import com.binaryHunter.carShow.entity.Car;
import com.binaryHunter.carShow.entity.Owner;
import com.binaryHunter.carShow.repository.CarRepository;
import com.binaryHunter.carShow.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

//combination of other notations
//@EnableAutoConfiguration //will detect your dependencies based on your dependencies
//@ComponentScan //This enables the Spring Boot ComponentScan to find all components in the app
//@Configuration //This annotation is used to define a configuration class that provides beans to the Spring app
@SpringBootApplication
public class CarShowApplication implements CommandLineRunner /*implement this for testing dummy data */ {
	@Autowired //inject a bean for like a repository or service..
	// this is like saying ```CarRepository carRepository = new carRepository()```
	private CarRepository carRepository; //only has access to the database // the repository
	@Autowired
	private OwnerRepository ownerRepository;
private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception /* will be run before Springboot*/ {
		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Dastan", "Smith");
		ownerRepository.save(owner1);
		ownerRepository.save(owner2);
		List<Car> cars = Arrays.asList(
						new Car("Ford","Lighting","Gray","FL-234",2023,75000, owner1),
						new Car("Nissan","Leaf","Green","BFG-345",2022,40000, owner2),
						new Car("Toyota","Sienna","Silver","CDF-233",2024,60000, owner1),
						new Car("Honda","Accord","White","HW-345",2024,57000, owner2)
		);
		carRepository.saveAll(cars);
		carRepository.findAll().forEach(car -> logger.info(car.getMake() + " " + car.getModel()));
	}

	// ORM is the (idea)
	// ORM (Object Relation Mapping) : is a technique that allows you to fetch from and manipulate
	// a database by using OOP paradigm. -> Hibernate (implementation of JPA)
	// class Book (id, title, author, price) -> Table Book (id, title, author, price)
	// ORM turns an object into a table & vise versa
	// JPA Java Persistent API : (idea) of how a class should be used
	// entity class that will become a table -> table

}
