package com.aos.onlineshop.warehouse.service;

import com.aos.onlineshop.warehouse.persistence.model.Item;

import java.util.List;

public interface ItemService {

  Item getItem(long id);

  List<Item> getAllItems();

  Item updateItem(long itemId, Item item);

}
