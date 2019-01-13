package com.aos.onlineshop.billing.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  private long userId;

  private long warehouseId;

  private double total;

}
