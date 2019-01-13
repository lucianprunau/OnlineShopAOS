package com.aos.onlineshop.usermanagement.service;

import com.aos.onlineshop.usermanagement.persistence.model.Cart;

import java.util.List;

public interface CartService {

  Cart addCart(Cart cart);

  Cart getCart(long id);

  List<Long> getAllItems(long cartId);

  void addItems(List<Long> items, long cartId);
}
