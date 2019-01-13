package com.aos.onlineshop.warehouse.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  private String name;
  private String location;

  @OneToMany(
      mappedBy = "warehouse",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @JsonIgnore
  private List<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    items.add(item);
    item.setWarehouse(this);
  }

  public void deleteItem(Item item) {
    items.remove(item);
    item.setWarehouse(null);
  }

  public void deleteAllItems(){
    for(Item item : items) {
      item.setWarehouse(null);
    }
    items.clear();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
