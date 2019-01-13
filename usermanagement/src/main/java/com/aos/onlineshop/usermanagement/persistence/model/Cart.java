package com.aos.onlineshop.usermanagement.persistence.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")

public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ElementCollection
  private List<Long> items = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Long> getItems() {
    return items;
  }

  public void setItems(List<Long> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cart)) return false;
    Cart cart = (Cart) o;
    return id == cart.id &&
        Objects.equals(items, cart.items) &&
        Objects.equals(user, cart.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, items, user);
  }

  @Override
  public String toString() {
    return "Cart{" +
        "id=" + id +
        ", user=" + user +
        ", items=" + items +
        '}';
  }
}
