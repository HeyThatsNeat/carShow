package com.binaryHunter.carShow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ownerId;
  private String firstName;
  private String lastName;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //one Owner can have many cars
  @JsonIgnore
  private List<Car> cars;

  public Owner() {
  }

  public Owner(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Owner{" +
            "ownerId=" + ownerId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  // One to One
  // Many to One
  // Many to Many
}
