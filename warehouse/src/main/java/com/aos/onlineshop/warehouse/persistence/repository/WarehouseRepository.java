package com.aos.onlineshop.warehouse.persistence.repository;

import com.aos.onlineshop.warehouse.persistence.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
