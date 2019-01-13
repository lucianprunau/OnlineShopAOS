package com.aos.onlineshop.warehouse.service;

import com.aos.onlineshop.warehouse.persistence.model.Item;
import com.aos.onlineshop.warehouse.persistence.model.Warehouse;

import java.util.List;

public interface WarehouseService {

  Warehouse getWarehouse(long id);

  List<Warehouse> getAllWarehouses();

  Warehouse addWarehouse(Warehouse warehouse);

  List<Item> getAllItems(long warehouseId);

  void addItemsToWarehouse(List<Item> items, long warehouseId);

  void removeItemFromWarehouse(Item item, long warehouseId);

  void removeAllItems(long warehouseId);

  Warehouse updateWarehouse(long warehouseId, Warehouse warehouse);

  void deleteWarehouse(long id);

  void deleteAllWarehouses();
}
