package com.aos.onlineshop.usermanagement.service;

import com.aos.onlineshop.usermanagement.persistence.model.User;
import com.aos.onlineshop.usermanagement.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  @Override
  public User findById(int id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public User findByEmail(String email) {
    return repository.findByEmail(email).orElse(null);
  }

  @Override
  public void saveUser(User user) {
    repository.save(user);
  }

  @Override
  public void updateUser(User user) {
    repository.save(user);
  }

  @Override
  public void deleteUserById(int id) {
    repository.deleteById(id);
  }

  @Override
  public List<User> findAllUsers() {
    return repository.findAll();
  }

  @Override
  public void deleteAllUsers() {
    repository.deleteAll();
  }

  @Override
  public boolean userExists(User user) {
    return repository.findByEmail(user.getEmail()).orElse(null) != null;
  }
}
