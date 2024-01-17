package com.binaryHunter.carShow.entity;

import jakarta.persistence.*;

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
  private String model;
  private String color;
  private String registerNumber;
  private int year;
  private double price;
  @ManyToOne(fetch = FetchType.EAGER) //many cars can have 1 owner //Eager will always fetch the date Owner no matter what.
  // even when not needed
  //Lazy is only when needed
  @JoinColumn(name = "owner") //add owner column
  private Owner owner;

  public Car() { //Hibernate will use this because @Entity says so
  }

  public Car(String make, String model, String color, String registerNumber, int year, double price, Owner owner) {
    this.make = make;
    this.model = model;
    this.color = color;
    this.registerNumber = registerNumber;
    this.year = year;
    this.price = price;
    this.owner = owner;
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

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
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
