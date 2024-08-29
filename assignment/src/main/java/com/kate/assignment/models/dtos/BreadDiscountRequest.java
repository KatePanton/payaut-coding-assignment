package com.kate.assignment.models.dtos;

public class BreadDiscountRequest {

    public Integer breadId;
    public Integer breadAge;
    public Integer breadQuantity = 1;

    // Getters and Setters
    public Integer getBreadId() {
        return breadId;
    }

    public void setBreadId(Integer breadId) {
        this.breadId = breadId;
    }

    public Integer getBreadAge() {
        return breadAge;
    }

    public void setBreadAge(Integer breadAge) {
        this.breadAge = breadAge;
    }

    public Integer getBreadQuantity() {
        return breadQuantity != null ? breadQuantity : 1;
    }

    public void setBreadQuantity(Integer breadQuantity) {
        this.breadQuantity = breadQuantity;
    }
}
