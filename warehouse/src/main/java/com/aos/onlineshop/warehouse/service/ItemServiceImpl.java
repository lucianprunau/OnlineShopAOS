package com.aos.onlineshop.warehouse.service;

import com.aos.onlineshop.warehouse.persistence.model.Item;
import com.aos.onlineshop.warehouse.persistence.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

  private ItemRepository repo;

  @Autowired
  public ItemServiceImpl(ItemRepository itemRepository) {
    this.repo = itemRepository;
  }

  @Override
  public Item getItem(long id) {
    return repo.findById(id).get();
  }

  @Override
  public List<Item> getAllItems() {
    return repo.findAll();
  }

  @Override
  @Transactional
  public Item updateItem(long itemId, Item item) {
    Item itemToUpdate = getItem(itemId);
    itemToUpdate.setDescription(item.getDescription());
    itemToUpdate.setName(item.getName());
    itemToUpdate.setPrice(item.getPrice());
    itemToUpdate.setQuantity(item.getQuantity());
    return repo.saveAndFlush(itemToUpdate);
  }
}
