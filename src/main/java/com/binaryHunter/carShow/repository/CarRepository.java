package com.binaryHunter.carShow.repository;

import com.binaryHunter.carShow.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> /*<Object, Object ID>*/ {
  //CRUD
}
