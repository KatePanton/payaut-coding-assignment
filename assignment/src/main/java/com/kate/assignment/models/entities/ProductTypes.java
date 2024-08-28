package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductTypes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer ProductTypeId;
  public String ProductTypeName;

  // Constructors
  public ProductTypes() {
  };

  public ProductTypes(Integer productTypeId, String productTypeName) {
    this.ProductTypeId = productTypeId;
    this.ProductTypeName = productTypeName;
  }

  // Getters and Setters
  public Integer getProductTypeId() {
    return ProductTypeId;
  }

  public void setProductTypeId(Integer productTypeId) {
    this.ProductTypeId = productTypeId;
  }

  public String getProductTypeName() {
    return ProductTypeName;
  }

  public void setProductTypeName(String productTypeName) {
    this.ProductTypeName = productTypeName;
  }
}
