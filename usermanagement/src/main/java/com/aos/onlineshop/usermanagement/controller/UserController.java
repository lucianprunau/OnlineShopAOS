package com.aos.onlineshop.usermanagement.controller;

import com.aos.onlineshop.usermanagement.persistence.model.User;
import com.aos.onlineshop.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;  //Service which will do all data retrieval/manipulation work

  //-------------------Retrieve All Users--------------------------------------------------------

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.findAllUsers();
    if(users.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(users, HttpStatus.OK);
  }


  //-------------------Retrieve Single User--------------------------------------------------------

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUser(@PathVariable("id") int id) {
    System.out.println("Fetching User with id " + id);
    User user = userService.findById(id);
    if (user == null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.OK);
  }



  //-------------------Create a User--------------------------------------------------------

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> createUser(@RequestBody User user) {
    System.out.println("Creating user with email:" + user.getEmail());

    if (userService.userExists(user)) {
      System.out.println("A User with email: " + user.getEmail() + " already exist");
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    userService.saveUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }


  //------------------- Update a User --------------------------------------------------------

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
    System.out.println("Updating User " + id);

    User currentUser = userService.findById(id);

    if (currentUser ==null) {
      System.out.println("User with id " + id + " not found");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    currentUser.setEmail(user.getEmail());
    currentUser.setFirstName(user.getFirstName());
    currentUser.setLastName(user.getLastName());

    userService.updateUser(currentUser);
    return new ResponseEntity<>(currentUser, HttpStatus.OK);
  }

  //------------------- Delete a User --------------------------------------------------------

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
    System.out.println("Fetching & Deleting User with id " + id);

    User user = userService.findById(id);
    if (user == null) {
      System.out.println("Unable to delete. User with id " + id + " not found");
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    userService.deleteUserById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


  //------------------- Delete All Persons --------------------------------------------------------

  @RequestMapping(method = RequestMethod.DELETE)
  public ResponseEntity<User> deleteAllUsers() {
    System.out.println("Deleting All Persons");

    userService.deleteAllUsers();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
