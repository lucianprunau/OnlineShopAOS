package com.aos.onlineshop.usermanagement.service;

import com.aos.onlineshop.usermanagement.persistence.model.User;

import java.util.List;

public interface UserService {
  User findById(int id);

  User findByEmail(String email);

  void saveUser(User user);

  void updateUser(User user);

  void deleteUserById(int id);

  List<User> findAllUsers();

  void deleteAllUsers();

  boolean userExists(User user);
}
