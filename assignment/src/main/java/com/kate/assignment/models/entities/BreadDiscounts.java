package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BreadDiscounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer BreadDiscountId;

    @ManyToOne
    @JoinColumn(name = "BreadId", nullable = false)
    public Breads Bread;

    public Integer DaysOld;
    public Number DiscountPercentage;

    // Constructors
    public BreadDiscounts() {
    };

    public BreadDiscounts(Integer breadDiscountId, Breads bread, Integer daysOld, Number discountPercentage) {
        this.BreadDiscountId = breadDiscountId;
        this.Bread = bread;
        this.DaysOld = daysOld;
        this.DiscountPercentage = discountPercentage;
    }

    // Getters and Setters
    public void setBreadDiscountId(Integer breadDiscountId) {
        this.BreadDiscountId = breadDiscountId;
    }

    public Integer getBreadDiscountId() {
        return BreadDiscountId;
    }

    public void setBread(Breads bread) {
        this.Bread = bread;
    }

    public Breads getBread() {
        return Bread;
    }

    public void setDaysOld(Integer daysOld) {
        this.DaysOld = daysOld;
    }

    public Integer getDaysOld() {
        return DaysOld;
    }

    public void setDiscountPercentage(Number discountPercentage) {
        this.DiscountPercentage = discountPercentage;
    }

    public Number getDiscountPercentage() {
        return DiscountPercentage;
    }

}
