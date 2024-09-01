package com.kate.assignment.models.entities;

import com.kate.assignment.models.interfaces.BeerInterface;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Beers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer BeerId;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId", nullable = false)
    public ProductTypes ProductType;

    public Number Price;
    public String Brand;

    // Constructors
    public Beers() {
    };

    public Beers(BeerInterface beerInterface) {
        this.BeerId = beerInterface.getBeerId();
        this.Price = beerInterface.getPrice();
        this.Brand = beerInterface.getBrand();
    }

    // Getters and Setters
    public void setBeerId(Integer beerId) {
        this.BeerId = beerId;
    }

    public Integer getBeerId() {
        return BeerId;
    }

    public void setProductType(ProductTypes productType) {
        this.ProductType = productType;
    }

    public ProductTypes getProductType() {
        return ProductType;
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

}
