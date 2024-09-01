package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.VegWithDiscountInterface;

public class VegWithDiscount {
    public Integer VegetableId;

    public Number Price;

    public Integer VegetableDiscountId;

    public Integer MinimumWeight;

    public Number DiscountPercentage;

    public Integer VegetableWeight;

    public Number DiscountGiven;

    public Number AmountPayable;

    public VegWithDiscount(VegWithDiscountInterface vegWithDiscountInterface) {
        this.VegetableId = vegWithDiscountInterface.getVegetableId();
        this.Price = vegWithDiscountInterface.getPrice();
        this.VegetableDiscountId = vegWithDiscountInterface.getVegetableDiscountId();
        this.MinimumWeight = vegWithDiscountInterface.getMinimumWeight();
        this.DiscountPercentage = vegWithDiscountInterface.getDiscountPercentage();
        this.VegetableWeight = vegWithDiscountInterface.getVegetableWeight();
        this.DiscountGiven = vegWithDiscountInterface.getDiscountGiven();
        this.AmountPayable = vegWithDiscountInterface.getAmountPayable();
    }

    public void setDiscount(Integer vegetableWeight, Number discountPercentage) {
        this.VegetableWeight = vegetableWeight;
        if (DiscountPercentage == null) {
            this.DiscountGiven = 0;
            return;
        }

        this.DiscountGiven = discountPercentage;
        this.AmountPayable = (Price.doubleValue() * vegetableWeight) * (1 - DiscountGiven.doubleValue());
    }
}
