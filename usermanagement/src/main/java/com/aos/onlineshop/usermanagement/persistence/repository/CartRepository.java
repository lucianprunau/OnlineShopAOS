package com.aos.onlineshop.usermanagement.persistence.repository;

import com.aos.onlineshop.usermanagement.persistence.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
