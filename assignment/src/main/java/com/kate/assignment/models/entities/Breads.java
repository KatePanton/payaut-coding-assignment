package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Breads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer BreadId;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId", nullable = false)
    public ProductTypes ProductType;

    public Number Price;

    // Constructors
    public Breads() {
    };

    public Breads(Integer breadId, Number price, ProductTypes productType) {
        this.BreadId = breadId;
        this.ProductType = productType;
        this.Price = price;
    }

    // Getters and Setters
    public void setBreadId(Integer breadId) {
        this.BreadId = breadId;
    }

    public void setProductType(ProductTypes productType) {
        this.ProductType = productType;
    }

    public ProductTypes getProductType() {
        return ProductType;
    }

    public Integer getBreadId() {
        return BreadId;
    }

    public void setPrice(Number price) {
        this.Price = price;
    }

    public Number getPrice() {
        return Price;
    }

}
