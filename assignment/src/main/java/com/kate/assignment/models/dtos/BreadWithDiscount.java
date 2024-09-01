package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.BreadWithDiscountInterface;

public class BreadWithDiscount {
    public Integer BreadId;

    public Number Price;

    public Integer BreadDiscountId;

    public Integer MaxAge;

    public Integer ExtraQuantity;

    public Integer BreadAge;

    public Integer BreadQuantity;

    public Number AmountPayable;

    public BreadWithDiscount(BreadWithDiscountInterface breadWithDiscountInterface) {
        this.BreadId = breadWithDiscountInterface.getBreadId();
        this.Price = breadWithDiscountInterface.getPrice();
        this.BreadDiscountId = breadWithDiscountInterface.getBreadDiscountId();
        this.MaxAge = breadWithDiscountInterface.getMaxAge();
        this.ExtraQuantity = breadWithDiscountInterface.getExtraQuantity();
        this.BreadAge = breadWithDiscountInterface.getBreadAge();
        this.BreadQuantity = breadWithDiscountInterface.getBreadQuantity();
        this.AmountPayable = breadWithDiscountInterface.getAmountPayable();
    }

    public void setDiscount(Integer breadAge, Integer breadQuantity, Integer extraQuantity) {
        this.BreadAge = breadAge;

        if (extraQuantity == null) {
            this.BreadQuantity = breadQuantity;
            return;
        }

        this.AmountPayable = (Price.doubleValue() * breadQuantity);
        this.BreadQuantity = breadQuantity + (extraQuantity * breadQuantity);
    }
}
