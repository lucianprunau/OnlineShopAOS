package com.aos.onlineshop.billing.persistence.repository;

import com.aos.onlineshop.billing.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
