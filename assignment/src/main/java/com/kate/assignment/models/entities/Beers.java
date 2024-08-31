package com.kate.assignment.models.entities;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Beers {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer BeerId;
    public Number Price;
    public String Brand;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId", nullable = false)
    public ProductTypes ProductType;

    // Constructors
    public Beers() {
    };

    // public Beers(Integer beerId, Number price, String brand, ProductTypes
    // productType) {
    // this.BeerId = beerId;
    // this.Price = price;
    // this.Brand = brand;
    // this.ProductType = productType;
    // }

    public Beers(Number price, String brand, String productTypeName) {

        this.BeerId = idGenerator.getAndIncrement();
        this.Price = price;
        this.Brand = brand;
        this.ProductType = new ProductTypes(productTypeName);
    }

    // Getters and Setters
    public void setBeerId(Integer beerId) {
        this.BeerId = beerId;
    }

    public Integer getBeerId() {
        return BeerId;
    }

    public void setPrice(Number Price) {
        this.Price = Price;
    }

    public Number getPrice() {
        return Price;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getBrand() {
        return Brand;
    }

    public void setProductType(ProductTypes productType) {
        this.ProductType = productType;
    }

    public ProductTypes getProductType() {
        return ProductType;
    }

}
