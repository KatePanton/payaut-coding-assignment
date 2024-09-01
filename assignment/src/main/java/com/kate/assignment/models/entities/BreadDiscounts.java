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

    public Number MaxAge;
    public Integer ExtraQuantity;

    // Constructors
    public BreadDiscounts() {
    };

    public BreadDiscounts(Integer breadDiscountId, Breads bread, Number maxAge, Integer extraQuantity) {
        this.BreadDiscountId = breadDiscountId;
        this.Bread = bread;
        this.MaxAge = maxAge;
        this.ExtraQuantity = extraQuantity;
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

    public void setMaxAge(Number maxAge) {
        this.MaxAge = maxAge;
    }

    public Number getMaxAge() {
        return MaxAge;
    }

    public void setExtraQuantity(Integer extraQuantity) {
        this.ExtraQuantity = extraQuantity;
    }

    public Integer getExtraQuantity() {
        return ExtraQuantity;
    }

}
