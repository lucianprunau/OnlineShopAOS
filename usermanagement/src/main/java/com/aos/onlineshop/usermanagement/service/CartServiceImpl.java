package com.aos.onlineshop.usermanagement.service;

import com.aos.onlineshop.usermanagement.persistence.model.Cart;
import com.aos.onlineshop.usermanagement.persistence.model.User;
import com.aos.onlineshop.usermanagement.persistence.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

  private CartRepository repo;

  @Autowired
  public CartServiceImpl(CartRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<Long> getAllItems(long cartId) {
    return repo.findById(cartId).get().getItems();
  }

  @Override
  public Cart getCart(long cartId) {
    return repo.findById(cartId).orElse(null);
  }

  @Override
  public Cart addCart(Cart cart) {
    User user = cart.getUser();
    return repo.saveAndFlush(cart);
  }

  @Override
  @Transactional
  public void addItems(List<Long> items, long cartId) {
    Cart cart = getCart(cartId);
    for(Long item : items) {
      cart.getItems().add(item);
    }
    repo.saveAndFlush(cart);
  }
}
