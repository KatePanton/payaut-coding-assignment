package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VegetableDiscounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer VegetableDiscountId;

    @ManyToOne
    @JoinColumn(name = "VegetableId", nullable = false)
    public Vegetables Vegetable;

    public Integer MinimumWeight;
    public Integer MaximumWeight;
    public Number DiscountPercentage;

    // Constructors
    public VegetableDiscounts() {
    };

    public VegetableDiscounts(Integer vegetableDiscountId, Vegetables vegetable, Integer minimumWeight,
            Integer maximumWeight, Number discountPercentage) {
        this.VegetableDiscountId = vegetableDiscountId;
        this.Vegetable = vegetable;
        this.MinimumWeight = minimumWeight;
        this.MaximumWeight = maximumWeight;
        this.DiscountPercentage = discountPercentage;
    }

    // Getters and Setters
    public void setVegetableDiscountId(Integer VegetableId) {
        this.VegetableDiscountId = VegetableId;
    }

    public Integer getVegetableDiscountId() {
        return VegetableDiscountId;
    }

    public void setVegetableId(Vegetables vegetable) {
        this.Vegetable = vegetable;
    }

    public Vegetables getVegetableId() {
        return Vegetable;
    }

    public void setMinimumWeight(Integer minimumWeight) {
        this.MinimumWeight = minimumWeight;
    }

    public Integer getMinimumWeight() {
        return MinimumWeight;
    }

    public void setMaximumWeight(Integer maximumWeight) {
        this.MaximumWeight = maximumWeight;
    }

    public Integer getMaximumWeight() {
        return MaximumWeight;
    }

    public void setDiscountPercentage(Number discountPercentage) {
        this.DiscountPercentage = discountPercentage;
    }

    public Number getDiscountPercentage() {
        return DiscountPercentage;
    }

}
