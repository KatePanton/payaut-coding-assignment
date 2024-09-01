package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.createUpdateDtos.BeerCreateUpdateRequest;
import com.kate.assignment.models.createUpdateDtos.BeerDiscountCreateUpdateRequest;
import com.kate.assignment.models.dtos.BeerDiscountRequest;
import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.models.entities.BeerDiscounts;
import com.kate.assignment.models.entities.Beers;
import com.kate.assignment.models.interfaces.BeerInterface;
import com.kate.assignment.models.interfaces.BeerWithDiscountInterface;
import com.kate.assignment.repositories.BeerRepository;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private ProductTypeService productTypeService;

    // Add
    public String addBeer(BeerCreateUpdateRequest beerCreateUpdateRequest) {

        var productType = productTypeService.getProductTypeByName(beerCreateUpdateRequest.getProductTypeName());

        try {
            beerRepository.addNewBeer(
                    beerCreateUpdateRequest.getPrice(),
                    beerCreateUpdateRequest.getBrand(),
                    productType.getProductTypeId());

            return "Beer added successfully";
        } catch (Exception e) {
            return "Beer not added";
        }
    }

    public String addBeerDiscount(BeerDiscountCreateUpdateRequest beerDiscountCreateUpdateRequest) {

        var beer = getBeerByBrand(beerDiscountCreateUpdateRequest.getBeerBrand());

        try {
            beerRepository.addNewBeerDiscount(

                    beerDiscountCreateUpdateRequest.getBottlesRequired(),
                    beerDiscountCreateUpdateRequest.getDiscountAmount(),
                    beer.getBeerId());

            return "Beer discount added successfully";
        } catch (Exception e) {
            return "Beer discount not added";

        }

    }

    // Get
    public Beers getBeerByBrand(String brand) {

        BeerInterface result = beerRepository.getBeerByBrand(brand);
        Beers beer = new Beers(result);

        return beer;
    }

    public BeerDiscounts getBeerDiscountByBrand(String brand) {

        BeerWithDiscountInterface result = beerRepository.getBeerDiscountByBrand(brand);
        BeerDiscounts beerDiscounts = new BeerDiscounts(result);

        return beerDiscounts;
    }

    public List<BeerWithDiscount> getAllBeers() {
        var holder = beerRepository.getAllBeers();

        List<BeerWithDiscount> beerWithDiscounts = holder.stream()
                .map(BeerWithDiscount::new)
                .collect(Collectors.toList());

        return beerWithDiscounts;
    }

    public List<BeerWithDiscount> getDiscount(List<BeerDiscountRequest> requests) {
        return requests.stream()
                .map(request -> determineDiscount(request.getBrand(), request.getBeerQuantity()))
                .collect(Collectors.toList());
    }

    private BeerWithDiscount determineDiscount(String brand, Integer beerQuantity) {
        var beer = getBeerByBrand(brand);

        var discountDetails = getDiscountDetails(beer.getBeerId(), brand);
        discountDetails.setDiscount(beerQuantity);

        return discountDetails;
    }

    private BeerWithDiscount getDiscountDetails(Integer beerId, String brand) {
        var holder = beerRepository.getDiscountDetails(beerId, brand);

        BeerWithDiscount beerWithDiscount = new BeerWithDiscount(holder);
        return beerWithDiscount;
    }

    // Update
    public String updateBeer(BeerCreateUpdateRequest beerCreateUpdateRequest) {

        var productType = productTypeService.getProductTypeByName(beerCreateUpdateRequest.getProductTypeName());
        var beer = getBeerByBrand(beerCreateUpdateRequest.getBrand());

        try {
            beerRepository.updateBeer(
                    beer.getBeerId(),
                    beerCreateUpdateRequest.getPrice(),
                    beerCreateUpdateRequest.getBrand(),
                    productType.getProductTypeId());

            return "Beer updated successfully";
        } catch (Exception e) {
            return "Beer not updated";
        }
    }

    public String updateBeerDiscount(BeerDiscountCreateUpdateRequest beerDiscountCreateUpdateRequest) {

        var beer = getBeerByBrand(beerDiscountCreateUpdateRequest.getBeerBrand());
        var beerDiscount = getBeerDiscountByBrand(beerDiscountCreateUpdateRequest.getBeerBrand());

        try {
            beerRepository.updateBeerDiscount(
                    beerDiscount.getBeerDiscountId(),
                    beerDiscountCreateUpdateRequest.getBottlesRequired(),
                    beerDiscountCreateUpdateRequest.getDiscountAmount().doubleValue(),
                    beer.getBeerId());

            return "Beer discount updated successfully";
        } catch (Exception e) {
            return "Beer discount not updated";
        }
    }

}
