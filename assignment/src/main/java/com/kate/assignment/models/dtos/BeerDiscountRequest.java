package com.kate.assignment.models.dtos;

public class BeerDiscountRequest {

    public Integer beerId;
    public String brand;
    public Integer beerQuantity;

    // getters and setters
    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getBeerQuantity() {
        return beerQuantity;
    }

    public void setBeerQuantity(Integer beerQuantity) {
        this.beerQuantity = beerQuantity;
    }

}
