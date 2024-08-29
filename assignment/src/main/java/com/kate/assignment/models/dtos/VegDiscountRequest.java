package com.kate.assignment.models.dtos;

public class VegDiscountRequest {

    private Integer vegetableId;
    private Integer vegetableQuantity;

    // Getters and Setters
    public Integer getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Integer vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Integer getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(Integer vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }

}
