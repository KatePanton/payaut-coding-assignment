package com.kate.assignment.models.interfaces;

public interface BreadWithDiscountInterface {
    Integer getBreadId();

    void setBreadId(Integer BreadId);

    Number getPrice();

    void setPrice(Number Price);

    Integer getBreadDiscountId();

    void setBreadDiscountId(Integer BreadDiscountId);

    Integer getDaysOld();

    void setDaysOld(Integer DaysOld);

    Number getDiscountPercentage();

    void setDiscountPercentage(Number DiscountPercentage);

    Integer getBreadAge();

    void setBreadAge(Integer BreadAge);

    Integer getDiscountGiven();

    void setDiscountGiven(Integer DiscountGiven);
}
