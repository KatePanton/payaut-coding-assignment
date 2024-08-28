package com.kate.assignment.models.dtos;

public interface BeerWithDiscount {

    Integer getBeerId();

    void setBeerId(Integer BeerId);

    String getBrand();

    void setBrand(String Brand);

    Number getPrice();

    void setPrice(Number Price);

    Integer getBeerDiscountId();

    void setBeerDiscountId(Integer BeerDiscountId);

    Integer getBottlesRequired();

    void setBottlesRequired(Integer BottlesRequired);

    Number getDiscountAmount();

    void setDiscountAmount(Number DiscountAmount);

    Number getDiscountGiven();

    void setDiscountGiven(Number DiscountGiven);

    default Number calculateDiscountGiven(Integer beerQuantity) {
        Integer bottlesRequired = getBottlesRequired();
        Number discountAmount = getDiscountAmount();
        Number applicableDiscounts = beerQuantity / bottlesRequired;
        return applicableDiscounts.doubleValue() * discountAmount.doubleValue();
    }

}
