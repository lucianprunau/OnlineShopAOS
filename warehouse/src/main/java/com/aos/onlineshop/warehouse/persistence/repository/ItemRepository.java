package com.aos.onlineshop.warehouse.persistence.repository;

import com.aos.onlineshop.warehouse.persistence.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
