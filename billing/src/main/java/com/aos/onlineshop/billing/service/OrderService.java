package com.aos.onlineshop.billing.service;

import com.aos.onlineshop.billing.persistence.model.Order;

public interface OrderService {

  Order createOrder(long userId);

  void completeOrder(long orderId);
}
