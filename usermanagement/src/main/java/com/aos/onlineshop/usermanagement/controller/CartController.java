package com.aos.onlineshop.usermanagement.controller;

import com.aos.onlineshop.usermanagement.persistence.model.Cart;
import com.aos.onlineshop.usermanagement.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

  private CartService cartService;

  @Autowired
  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
    return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.OK);
  }

  @RequestMapping(path = "/{cartId}/items", method = RequestMethod.GET)
  public ResponseEntity<List<Long>> getItems(@PathVariable(name = "cartId") long cartId) {
    return new ResponseEntity<>(cartService.getAllItems(cartId), HttpStatus.OK);
  }

  @RequestMapping(path = "/{cartId}/items", method = RequestMethod.POST)
  public ResponseEntity<Void> addItems(@PathVariable(name = "cartId") long cartId,
                                       @RequestBody List<Long> items) {
    cartService.addItems(items, cartId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "/{cartId}", method = RequestMethod.GET)
  public ResponseEntity<Cart> getCart(@PathVariable(name = "cartId") long cartId) {
    return new ResponseEntity<>(cartService.getCart(cartId), HttpStatus.OK);
  }

}
