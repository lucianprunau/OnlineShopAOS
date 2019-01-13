package com.aos.onlineshop.billing.service;

import com.aos.onlineshop.billing.persistence.model.Cart;
import com.aos.onlineshop.billing.persistence.model.Item;
import com.aos.onlineshop.billing.persistence.model.Order;
import com.aos.onlineshop.billing.persistence.model.User;
import com.aos.onlineshop.billing.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

  OrderRepository repo;

  @Autowired
  public OrderServiceImpl(OrderRepository repo) {
    this.repo = repo;
  }

  @Override
  public Order createOrder(long userId) {
    RestTemplate restTemplate = new RestTemplate();
    String userResourceUrl = "http://localhost:8701/user/";
    String itemResourceUrl = "http://localhost:8700/item/list";
    User user = restTemplate.getForObject(userResourceUrl + userId, User.class);
    Cart cart = user.getCart();
    List<Long> itemIds = cart.getItems();

    HttpEntity<List<Long>> requestBody = new HttpEntity<>(itemIds);
    List<Item> items = restTemplate.postForObject(itemResourceUrl, requestBody, List.class);
    System.out.println(items.get(0));
    return null;
  }

  @Override
  public void completeOrder(long orderId) {

  }
}
