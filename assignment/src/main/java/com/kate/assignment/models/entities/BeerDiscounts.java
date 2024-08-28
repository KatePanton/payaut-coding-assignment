package com.kate.assignment.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BeerDiscounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer BeerDiscountId;

    @ManyToOne
    @JoinColumn(name = "BeerId", nullable = false)
    public Beers Beer;

    public Integer BottlesRequired;
    public Number DiscountAmount;

    // Constructors
    public BeerDiscounts() {
    };

    public BeerDiscounts(Integer beerDiscountId, Beers beer, Integer bottlesRequired, Number discountAmount) {
        this.BeerDiscountId = beerDiscountId;
        this.Beer = beer;
        this.BottlesRequired = bottlesRequired;
        this.DiscountAmount = discountAmount;
    }

    // Getters and Setters
    public void setBeerDiscountId(Integer beerDiscountId) {
        this.BeerDiscountId = beerDiscountId;
    }

    public Integer getBeerDiscountId() {
        return BeerDiscountId;
    }

    public Beers getBeer() {
        return Beer;
    }

    public void setBeer(Beers beer) {
        this.Beer = beer;
    }

    public void setBottlesRequired(Integer bottlesRequired) {
        this.BottlesRequired = bottlesRequired;
    }

    public Integer getBottlesRequired() {
        return BottlesRequired;
    }

    public void setDiscountAmount(Number DiscountAmount) {
        this.DiscountAmount = DiscountAmount;
    }

    public Number getDiscountAmount() {
        return DiscountAmount;
    }

}
