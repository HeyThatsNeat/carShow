package com.binaryHunter.carShow.repository;

import com.binaryHunter.carShow.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> /*<Object, Object ID>*/ {
  // REST (Representational State Transfer)
  // is an architectural style for create web services
  //SOAP, GraphQL are other
  // six constraints to REST
  //1. Stateless: The server does not hold any info about the client state. Each request and response is independent of each other
  //2. Client and server
  //3. Casheable
  //4. Uniform Interface: Requests of different clients look the same (including the link and its resources :remember resources package:)
  //5. Layered System: multiple servers coming together to make 1
  //6. (optional) Code on Demand:


  List<Car> getAllCarsByMake(String make);
  List<Car> findCarsByMakeAndModelOrderByYear(String make, String model);
}
