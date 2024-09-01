package com.kate.assignment.models.dtos;

import java.util.List;

public class OrderWithDiscounts {

    public List<BeerWithDiscount> beerWithDiscounts;
    public List<BreadWithDiscount> breadWithDiscounts;
    public List<VegWithDiscount> vegWithDiscounts;
    public Number TotalAmountPayable;

    // Constructors
    public OrderWithDiscounts() {
    };

}
