package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vegetables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer VegetableId;
    public Number Price;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId", nullable = false)
    public ProductTypes ProductType;

    // Constructors
    public Vegetables() {
    };

    public Vegetables(Integer vegetableId, Number price, ProductTypes productType) {
        this.VegetableId = vegetableId;
        this.Price = price;
        this.ProductType = productType;
    }

    // Getters and Setters
    public void setVegetableId(Integer vegetableId) {
        this.VegetableId = vegetableId;
    }

    public Number getVegetableId() {
        return VegetableId;
    }

    public void setPrice(Number Price) {
        this.Price = Price;
    }

    public Number getPrice() {
        return Price;
    }

    public void setProductType(ProductTypes productType) {
        this.ProductType = productType;
    }

    public ProductTypes getProductType() {
        return ProductType;
    }

}
