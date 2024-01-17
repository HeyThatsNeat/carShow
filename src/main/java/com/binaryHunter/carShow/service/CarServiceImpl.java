package com.binaryHunter.carShow.service;

import com.binaryHunter.carShow.entity.Car;
import com.binaryHunter.carShow.exception.ResourceNotFoundException;
import com.binaryHunter.carShow.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service //allows to inject in CarController
public class CarServiceImpl implements CarService{
  private final CarRepository carRepository;
//constructor injection vs field injection (look this up)
  public CarServiceImpl(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public List<Car> getCars() {
    return (List<Car>) carRepository.findAll();
  }

  @Override
  public Car getCarById(Long id) {
    // DIFFERENT WAYS TO WORK WITH OPTIONALS
//    Optional<String> optional = Optional.of("Hello, world!");
//    optional.get(); return it if it has a value
        //String s = null;
        //Optional<String> op = Optional.ofNullable(s);
        //op.get()
            //Optional<String> op = Optional.of("Hello");
            //if (op.isPresent()) {
            //  String s = op.get();
            // System.out.println(s);
            //} else {
            // System.out.println("nothing is Present");
                //String s = op.orElse("No such value")
                  //String s = op.orElseThrow();
//  ```  Optional<Car> optionalCar = carRepository.findById(id); //.findAll and .findById returns an Optional
//       if (optionalCar.isPresent()) {
//         return optionalCar.get();
//       } else {
//         throw new ResourceNotFoundException("Car with id " + id + " not found");
//       } ```
    return carRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Car with id " + id + " not found."));
  }
  //Optionals: is a container object used to represent a value that may or may not be present (null)

  @Override
  public Car addCar(Car car) {
    return carRepository.save(car);
  }

  @Override
  public void deleteCarById(Long id){
    carRepository.deleteById(id);
  }

  @Override
  public Car updateCarById(Long id, Car car) {
    Car existingCar = getCarById(id);
    existingCar.setMake(car.getMake());
    existingCar.setModel(car.getModel());
    existingCar.setColor(car.getColor());
    existingCar.setRegisterNumber(car.getRegisterNumber());
    existingCar.setYear(car.getYear());
    existingCar.setPrice(car.getPrice());
    carRepository.save(existingCar);
    return existingCar;
  }

  @Override
  public List<Car> getCarsByMake(String make) {
    return carRepository.getAllCarsByMake(make);
  }


}
