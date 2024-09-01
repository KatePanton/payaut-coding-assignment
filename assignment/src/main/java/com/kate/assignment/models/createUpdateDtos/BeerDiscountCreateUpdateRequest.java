package com.kate.assignment.models.createUpdateDtos;

public class BeerDiscountCreateUpdateRequest {

    public Integer beerDiscountId;

    public Integer beerId;

    public String beerBrand;

    public Integer bottlesRequired;

    public Number discountAmount;

    // getters and setters
    public Integer getBeerDiscountId() {
        return beerDiscountId;
    }

    public void setBeerDiscountId(Integer beerDiscountId) {
        this.beerDiscountId = beerDiscountId;
    }

    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }

    public String getBeerBrand() {
        return beerBrand;
    }

    public void setBeerBrand(String beerBrand) {
        this.beerBrand = beerBrand;
    }

    public Integer getBottlesRequired() {
        return bottlesRequired;
    }

    public void setBottlesRequired(Integer bottlesRequired) {
        this.bottlesRequired = bottlesRequired;
    }

    public Number getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Number discountAmount) {
        this.discountAmount = discountAmount;
    }

}
