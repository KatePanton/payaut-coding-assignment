package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.BreadWithDiscountInterface;

public class BreadWithDiscount {
    public Integer BreadId;

    public Number Price;

    public Integer BreadDiscountId;

    public Integer DaysOld;

    public Number DiscountPercentage;

    public Integer BreadAge;

    public Integer DiscountGiven;

    // DiscountPercentage => QuantityForFree
    // BreadQuantity

    public BreadWithDiscount(BreadWithDiscountInterface breadWithDiscountInterface) {
        this.BreadId = breadWithDiscountInterface.getBreadId();
        this.Price = breadWithDiscountInterface.getPrice();
        this.BreadDiscountId = breadWithDiscountInterface.getBreadDiscountId();
        this.DaysOld = breadWithDiscountInterface.getDaysOld();
        this.DiscountPercentage = breadWithDiscountInterface.getDiscountPercentage();
        this.BreadAge = breadWithDiscountInterface.getBreadAge();
        this.DiscountGiven = breadWithDiscountInterface.getDiscountGiven();
    }

    public void setDiscount(Integer BreadAge) {
        this.BreadAge = BreadAge;
        if (DiscountPercentage == null) {
            this.DiscountGiven = 0;
            return;
        }

        this.DiscountGiven = 3;
    }
}
