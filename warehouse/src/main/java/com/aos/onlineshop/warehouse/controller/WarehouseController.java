package com.aos.onlineshop.warehouse.controller;

import com.aos.onlineshop.warehouse.persistence.model.Item;
import com.aos.onlineshop.warehouse.persistence.model.Warehouse;
import com.aos.onlineshop.warehouse.service.ItemService;
import com.aos.onlineshop.warehouse.service.WarehouseService;
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
@RequestMapping("/warehouse")
public class WarehouseController {

  private WarehouseService warehouseService;
  private ItemService itemService;

  @Autowired
  public WarehouseController(WarehouseService warehouseService, ItemService itemService) {
    this.warehouseService = warehouseService;
    this.itemService = itemService;
  }

  @RequestMapping(path = "/{warehouseId}/items", method = RequestMethod.GET)
  public ResponseEntity<List<Item>> getItems(@PathVariable(name = "warehouseId") long warehouseId) {
    return new ResponseEntity<>(warehouseService.getAllItems(warehouseId), HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}/items", method = RequestMethod.POST)
  public ResponseEntity<Void> addItems(@PathVariable(name = "warehouseId") long warehouseId,
                                       @RequestBody List<Item> items) {
    warehouseService.addItemsToWarehouse(items, warehouseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}/items/{itemId}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> removeItem(@PathVariable(name = "warehouseId") long warehouseId,
                                         @PathVariable(name = "itemId") long itemId) {
    warehouseService.removeItemFromWarehouse(itemService.getItem(itemId), warehouseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}/items", method = RequestMethod.DELETE)
  public ResponseEntity<Void> removeAllItems(@PathVariable(name = "warehouseId") long warehouseId) {
    warehouseService.removeAllItems(warehouseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteWarehouse(@PathVariable(name = "warehouseId") long warehouseId) {
    warehouseService.deleteWarehouse(warehouseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}", method = RequestMethod.GET)
  public ResponseEntity<Warehouse> getWarehouse(@PathVariable(name = "warehouseId") long warehouseId) {
    return new ResponseEntity<>(warehouseService.getWarehouse(warehouseId), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Warehouse>> getAllWarehouses() {
    return new ResponseEntity<>(warehouseService.getAllWarehouses(), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
    return new ResponseEntity<>(warehouseService.addWarehouse(warehouse), HttpStatus.OK);
  }

  @RequestMapping(path = "/{warehouseId}", method = RequestMethod.PUT)
  public ResponseEntity<Warehouse> updateWarehouse(@PathVariable(name = "warehouseId") long warehouseId,
                                                   @RequestBody Warehouse warehouse) {
    return new ResponseEntity<>(warehouseService.updateWarehouse(warehouseId, warehouse), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteAllWarehouses() {
    warehouseService.deleteAllWarehouses();
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
