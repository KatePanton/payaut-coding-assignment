package com.kate.assignment.models.entities;

public class Orders {
  public Integer OrderId;
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
