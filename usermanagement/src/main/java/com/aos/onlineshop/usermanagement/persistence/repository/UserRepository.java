package com.aos.onlineshop.usermanagement.persistence.repository;

import com.aos.onlineshop.usermanagement.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
  Optional<User> findByEmail(String email);
}
