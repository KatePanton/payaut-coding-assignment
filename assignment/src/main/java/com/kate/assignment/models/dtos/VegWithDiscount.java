package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.VegWithDiscountInterface;

public class VegWithDiscount {
    public Integer VegetableId;

    public Number Price;

    public Integer VegetableDiscountId;

    public Integer MinimumWeight;

    public Integer MaximumWeight;

    public Number DiscountPercentage;

    public Integer VegetableQuantity;

    public Number DiscountGiven;

    public VegWithDiscount(VegWithDiscountInterface vegWithDiscountInterface) {
        this.VegetableId = vegWithDiscountInterface.getVegetableId();
        this.Price = vegWithDiscountInterface.getPrice();
        this.VegetableDiscountId = vegWithDiscountInterface.getVegetableDiscountId();
        this.MinimumWeight = vegWithDiscountInterface.getMinimumWeight();
        this.MaximumWeight = vegWithDiscountInterface.getMaximumWeight();
        this.DiscountPercentage = vegWithDiscountInterface.getDiscountPercentage();
        this.VegetableQuantity = vegWithDiscountInterface.getVegetableQuantity();
        this.DiscountGiven = vegWithDiscountInterface.getDiscountGiven();
    }

    public void setDiscount(Integer vegetableQuantity, Number discountPercentage) {
        this.VegetableQuantity = vegetableQuantity;
        if (DiscountPercentage == null) {
            this.DiscountGiven = 0;
            return;
        }

        this.DiscountGiven = discountPercentage;
    }
}
