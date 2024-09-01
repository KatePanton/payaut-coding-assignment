package com.kate.assignment.models.dtos;

import java.util.List;

public class OrderRequest {

    private List<BeerDiscountRequest> beerDiscountRequests;
    private List<BreadDiscountRequest> breadDiscountRequests;
    private List<VegDiscountRequest> vegDiscountRequests;

    // getters and setters
    public List<BeerDiscountRequest> getBeerDiscountRequests() {
        return beerDiscountRequests;
    }

    public void setBeerDiscountRequests(List<BeerDiscountRequest> beerDiscountRequests) {
        this.beerDiscountRequests = beerDiscountRequests;
    }

    public List<BreadDiscountRequest> getBreadDiscountRequests() {
        return breadDiscountRequests;
    }

    public void setBreadDiscountRequests(List<BreadDiscountRequest> breadDiscountRequests) {
        this.breadDiscountRequests = breadDiscountRequests;
    }

    public List<VegDiscountRequest> getVegDiscountRequests() {
        return vegDiscountRequests;
    }

    public void setVegDiscountRequests(List<VegDiscountRequest> vegDiscountRequests) {
        this.vegDiscountRequests = vegDiscountRequests;
    }
}
