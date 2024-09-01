package com.kate.assignment.models.dtos;

public class VegDiscountRequest {

    private Integer vegetableId;
    private Integer vegetableWeight;

    // Getters and Setters
    public Integer getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Integer vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Integer getVegetableWeight() {
        return vegetableWeight;
    }

    public void setVegetableWeight(Integer vegetableWeight) {
        this.vegetableWeight = vegetableWeight;
    }

}
