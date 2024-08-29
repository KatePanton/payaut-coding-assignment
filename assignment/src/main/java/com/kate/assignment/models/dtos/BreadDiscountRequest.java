package com.kate.assignment.models.dtos;

public class BreadDiscountRequest {

    private Integer breadId;
    public Integer breadAge;

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
}
