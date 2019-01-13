package com.aos.onlineshop.billing.controller;

import com.aos.onlineshop.billing.persistence.model.Order;
import com.aos.onlineshop.billing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @RequestMapping(path = "/create/{userId}")
  public ResponseEntity<Order> createOrder(@PathVariable(name = "userId") long userId) {
    Order createdOrder = orderService.createOrder(userId);
    if(createdOrder != null) {
      return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

  }
}
