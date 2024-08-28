package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer OrderId;

  @ManyToOne
  @JoinColumn(name = "ProductTypeId", nullable = false)
  public ProductTypes ProductType;

  public Integer ProductId;
  public Integer Quantity;
  public Number TotalPrice;
  public Number DiscountAmount;

  // Constructors
  public Orders() {
  };

  public Orders(Integer orderId, ProductTypes productType, Integer productId, Integer quantity, Number totalPrice,
      Number discountAmount) {
    this.OrderId = orderId;
    this.ProductType = productType;
    this.ProductId = productId;
    this.Quantity = quantity;
    this.TotalPrice = totalPrice;
    this.DiscountAmount = discountAmount;
  }

  // Getters and Setters
  public void setProductType(ProductTypes productType) {
    this.ProductType = productType;
  }

  public ProductTypes getProductType() {
    return ProductType;
  }
}
