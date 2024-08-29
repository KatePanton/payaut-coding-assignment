
package com.kate.assignment.models.interfaces;

public interface VegWithDiscountInterface {
    Integer getVegetableId();

    void setVegetableId(Integer VegetableId);

    Number getPrice();

    void setPrice(Number Price);

    Integer getVegetableDiscountId();

    void setVegetableDiscountId(Integer VegetableDiscountId);

    Integer getMinimumWeight();

    void setMinimumWeight(Integer MinimumWeight);

    Number getDiscountPercentage();

    void setDiscountPercentage(Number DiscountPercentage);

    Integer getVegetableWeight();

    void setVegetableWeight(Integer VegetableWeight);

    Number getDiscountGiven();

    void setDiscountGiven(Number DiscountGiven);

}
