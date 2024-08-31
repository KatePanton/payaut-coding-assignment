package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.BeerCreateUpdateRequest;
import com.kate.assignment.models.dtos.BeerDiscountRequest;
import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.models.entities.Beers;
import com.kate.assignment.repositories.BeerRepository;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private ProductTypeService productTypeService;

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
                .map(request -> determineDiscount(request.getBeerId(), request.getBrand(), request.getBeerQuantity()))
                .collect(Collectors.toList());

        // return determineDiscount(beerId, beerQuantity);
    }

    private BeerWithDiscount getDiscountDetails(Integer beerId, String brand) {
        var holder = beerRepository.getDiscountDetails(beerId, brand);

        BeerWithDiscount beerWithDiscount = new BeerWithDiscount(holder);
        return beerWithDiscount;
    }

    private BeerWithDiscount determineDiscount(Integer beerId, String brand, Integer beerQuantity) {

        var discountDetails = getDiscountDetails(beerId, brand);
        discountDetails.setDiscount(beerQuantity);

        return discountDetails;
    }

    // public Beers updateBeer(Beers beer) {
    // return beerRepository.save(beer);
    // }

    // public BeerWithDiscount updateBeerDiscount(BeerDiscounts beerDiscount) {
    // return beerRepository.updateBeerDiscount(
    // beerDiscount.getBeerDiscountId(),
    // beerDiscount.getBottlesRequired(),
    // beerDiscount.getDiscountAmount().doubleValue());
    // }

    public String addBeer(BeerCreateUpdateRequest beerCreateUpdateRequest) {

        var productType = productTypeService.getProductTypeByName(beerCreateUpdateRequest.getProductTypeName());

        beerRepository.save(new Beers(
                beerCreateUpdateRequest.getPrice(),
                beerCreateUpdateRequest.getBrand(),
                productType.getProductTypeName()));

        // beerRepository.addNewBeer(
        // beerCreateUpdateRequest.getPrice(),
        // beerCreateUpdateRequest.getBrand(),
        // productType.getProductTypeId());

        return "Beer added successfully";
    }

    // public String addBeerDiscount(BeerDiscountCreateUpdateRequest
    // beerDiscountCreateUpdateRequest) {

    // int beerId = beerDiscountCreateUpdateRequest.getBeerId();
    // int bottlesRequired = beerDiscountCreateUpdateRequest.getBottlesRequired();
    // double discountAmount =
    // beerDiscountCreateUpdateRequest.getDiscountAmount().doubleValue();

    // beerRepository.saveBeerDiscount(
    // beerId,
    // bottlesRequired,
    // discountAmount);

    // return "Beer discount added successfully";
    // }

}
