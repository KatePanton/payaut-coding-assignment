package com.kate.assignment.models.interfaces;

public interface BreadWithDiscountInterface {
    Integer getBreadId();

    void setBreadId(Integer BreadId);

    Number getPrice();

    void setPrice(Number Price);

    Integer getBreadDiscountId();

    void setBreadDiscountId(Integer BreadDiscountId);

    Integer getMaxAge();

    void setMaxAge(Integer MaxAge);

    Integer getExtraQuantity();

    void setExtraQuantity(Integer ExtraQuantity);

    Integer getBreadAge();

    void setBreadAge(Integer BreadAge);

    Integer getBreadQuantity();

    void setBreadQuantity(Integer BreadQuantity);

    Number getAmountPayable();

    void setAmountPayable(Number AmountPayable);
}
