package com.binaryHunter.carShow;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //a class that represents a table in the database
// @Table(name = "lovelyCarTable")   to change table name
// @Column(name = "car_Id")
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  //IDENTITY or AUTO
  //AUTO changes strategy to the right database
  private Long id;
  private String make;
  private String brand;
  private String model;
  private String color;
  private String registerNumber;
  private int year;
  private double price;

  public Car() { //Hibernate will use this because @Entity says so
  }

  public Car(String make, String model, String color, String registerNumber, int year, double price) {
    this.make = make;
    this.model = model;
    this.color = color;
    this.registerNumber = registerNumber;
    this.year = year;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegisterNumber() {
    return registerNumber;
  }

  public void setRegisterNumber(String registerNumber) {
    this.registerNumber = registerNumber;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", registerNumber='" + registerNumber + '\'' +
            ", year=" + year +
            ", price=" + price +
            '}';
  }
}
