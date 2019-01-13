package com.aos.onlineshop.warehouse.controller;

import com.aos.onlineshop.warehouse.persistence.model.Item;
import com.aos.onlineshop.warehouse.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {

  private ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @RequestMapping(path = "/{itemId}", method = RequestMethod.GET)
  public ResponseEntity<Item> getItem(@PathVariable(name = "itemId") long itemId) {
    return new ResponseEntity<>(itemService.getItem(itemId), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Item>> getItems() {
    return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
  }

  @RequestMapping(path = "/{itemId}", method = RequestMethod.PUT)
  public ResponseEntity<Item> updateItem(@PathVariable(name = "itemId") long itemId,
                                         @RequestBody Item item) {
    return new ResponseEntity<>(itemService.updateItem(itemId, item), HttpStatus.OK);
  }
}
