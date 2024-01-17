package com.binaryHunter.carShow.web;

import com.binaryHunter.carShow.entity.Car;
import com.binaryHunter.carShow.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // consists of Controller notation and ResponseBody notation\
@RequestMapping("/api/v1/car")
public class CarController {
  @Autowired
  private CarService carService;
  public CarController(CarService carService) {
    this.carService = carService;
  }
  //Json
  //JavaScript Object Notation
  @GetMapping("/cars")
  public ResponseEntity<List<Car>> getCars() {
    return new ResponseEntity<>(carService.getCars(), HttpStatus.OK); //200
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> getCarById(@PathVariable Long id) {
    return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    //200  if ResponseEntity is successful, display 200
  }
  //Http method indicate the action of an api client should

  @PostMapping("/add")
  public ResponseEntity<Car> addCar(@RequestBody Car car) {
    return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Car> deleteCarById(@PathVariable Long id) {
    carService.deleteCarById(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED); //or can use HttpStatus.NO_CONTENT
  }

  @PutMapping("/{id}")
  public ResponseEntity<Car> updateCarById(@PathVariable Long id,@RequestBody Car car) {
    return new ResponseEntity<>(carService.updateCarById(id,car), HttpStatus.ACCEPTED);
  }

  @GetMapping("/make/{make}")
  public ResponseEntity<List<Car>> getCarListByMake(@PathVariable String make) {
    return new ResponseEntity<>(carService.getCarsByMake(make), HttpStatus.OK);
  }

}
