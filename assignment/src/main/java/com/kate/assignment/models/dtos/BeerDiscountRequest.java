package com.kate.assignment.models.dtos;

public class BeerDiscountRequest {

    private Integer beerId;
    private Integer beerQuantity;

    // Getters and Setters
    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }

    public Integer getBeerQuantity() {
        return beerQuantity;
    }

    public void setBeerQuantity(Integer beerQuantity) {
        this.beerQuantity = beerQuantity;
    }

}
