package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.BeerDiscountRequest;
import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.repositories.BeerRepository;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    // get all Beers with their id, brand, and Price
    public List<BeerWithDiscount> getAllBeers() {
        var holder = beerRepository.getAllBeers();

        List<BeerWithDiscount> beerWithDiscounts = holder.stream()
                .map(BeerWithDiscount::new)
                .collect(Collectors.toList());

        return beerWithDiscounts;
    }

    // take in beer id & quantity, get required # for discount, determine discount.
    public List<BeerWithDiscount> getDiscount(List<BeerDiscountRequest> requests) {
        return requests.stream()
                .map(request -> determineDiscount(request.getBeerId(), request.getBeerQuantity()))
                .collect(Collectors.toList());

        // return determineDiscount(beerId, beerQuantity);
    }

    private BeerWithDiscount getDiscountDetails(Integer beerId) {
        var holder = beerRepository.getDiscountDetails(beerId);

        BeerWithDiscount beerWithDiscount = new BeerWithDiscount(holder);
        return beerWithDiscount;
    }

    private BeerWithDiscount determineDiscount(Integer beerId, Integer beerQuantity) {

        var discountDetails = getDiscountDetails(beerId);
        discountDetails.setDiscount(beerQuantity);

        return discountDetails;
    }

    // take in multiple beer ids & quantities, get required # for discount,
    // determine discount.

    // take in beer id, update bottles required and|or discount amount
    // add new beer + beerDiscount object.
}
