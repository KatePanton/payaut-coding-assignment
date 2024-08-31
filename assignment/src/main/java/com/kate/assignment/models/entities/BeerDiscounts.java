package com.kate.assignment.models.entities;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BeerDiscounts {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

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

    // public BeerDiscounts(Integer beerDiscountId, Beers beer, Integer
    // bottlesRequired, Number discountAmount) {
    // this.BeerDiscountId = beerDiscountId;
    // this.Beer = beer;
    // this.BottlesRequired = bottlesRequired;
    // this.DiscountAmount = discountAmount;
    // }

    public BeerDiscounts(Integer bottlesRequired, Number discountAmount, Integer beerId) {
        this.BeerDiscountId = idGenerator.getAndIncrement();
        this.BottlesRequired = bottlesRequired;
        this.DiscountAmount = discountAmount;
        this.Beer = new Beers();
        this.Beer.setBeerId(beerId);
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
