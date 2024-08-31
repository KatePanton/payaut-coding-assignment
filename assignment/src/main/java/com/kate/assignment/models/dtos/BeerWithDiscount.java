package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.BeerWithDiscountInterface;

public class BeerWithDiscount {

    public Integer BeerId;

    public String Brand;

    public Number Price;

    public Integer BeerDiscountId;

    public Integer BottlesRequired;

    public Number DiscountAmount;

    public Number BeerQuantity;

    public Number DiscountGiven;

    public Number AmountPayable;

    public BeerWithDiscount(BeerWithDiscountInterface beerWithDiscountInterface) {
        this.BeerId = beerWithDiscountInterface.getBeerId();
        this.Brand = beerWithDiscountInterface.getBrand();
        this.Price = beerWithDiscountInterface.getPrice();
        this.BeerDiscountId = beerWithDiscountInterface.getBeerDiscountId();
        this.BottlesRequired = beerWithDiscountInterface.getBottlesRequired();
        this.DiscountAmount = beerWithDiscountInterface.getDiscountAmount();
        this.BeerQuantity = beerWithDiscountInterface.getBeerQuantity();
        this.DiscountGiven = beerWithDiscountInterface.getDiscountGiven();
        this.AmountPayable = beerWithDiscountInterface.getAmountPayable();
    }

    public void setDiscount(Integer beerQuantity) {
        this.BeerQuantity = beerQuantity;
        if (BottlesRequired == null || DiscountAmount == null) {
            this.DiscountGiven = 0;
            return;
        }

        int discountMultiplier = beerQuantity / BottlesRequired;
        this.DiscountGiven = discountMultiplier * DiscountAmount.doubleValue();
        this.AmountPayable = (Price.doubleValue() * beerQuantity) - DiscountGiven.doubleValue();
    }
}
