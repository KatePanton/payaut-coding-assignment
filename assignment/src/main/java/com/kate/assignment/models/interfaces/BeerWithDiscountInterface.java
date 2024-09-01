
package com.kate.assignment.models.interfaces;

public interface BeerWithDiscountInterface {

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

    Number getBeerQuantity();

    void setBeerQuantity(Number BeerQuantity);

    Number getDiscountGiven();

    void setDiscountGiven(Number DiscountGiven);

    Number getAmountPayable();

    void setAmountPayable(Number AmountPayable);

}
