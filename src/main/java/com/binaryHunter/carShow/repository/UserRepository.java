package com.binaryHunter.carShow.repository;

import com.binaryHunter.carShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  //need method to return user by username
  Optional<User> findUserByUsername(String username);

}
