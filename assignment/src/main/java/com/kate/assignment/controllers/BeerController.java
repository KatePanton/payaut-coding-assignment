package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.createUpdateDtos.BeerCreateUpdateRequest;
import com.kate.assignment.models.createUpdateDtos.BeerDiscountCreateUpdateRequest;
import com.kate.assignment.models.dtos.BeerDiscountRequest;
import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.models.entities.Beers;
import com.kate.assignment.services.BeerService;

@RestController
@RequestMapping("/beers")
public class BeerController {

    public final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    // Add
    @PostMapping("/addBeer")
    public String addBeer(@RequestBody BeerCreateUpdateRequest beerCreateUpdateRequest) {
        return beerService.addBeer(beerCreateUpdateRequest);
    }

    @PostMapping("/addBeerDiscount")
    public String addBeerDiscount(
            @RequestBody BeerDiscountCreateUpdateRequest beerDiscountCreateUpdateRequest) {
        return beerService.addBeerDiscount(beerDiscountCreateUpdateRequest);
    }

    // Get
    @GetMapping("/getBeerByBrand")
    public Beers getBeerByBrand(@RequestBody BeerCreateUpdateRequest beerCreateUpdateRequest) {
        return beerService.getBeerByBrand(beerCreateUpdateRequest.getBrand());
    }

    @GetMapping("/getAll")
    public List<BeerWithDiscount> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/getDiscount")
    public List<BeerWithDiscount> getBeerDiscount(@RequestBody List<BeerDiscountRequest> beerDiscountRequests) {
        return beerService.getDiscount(beerDiscountRequests);
    }

    // Update
    @PutMapping("/updateBeer")
    public String updateBeer(@RequestBody BeerCreateUpdateRequest beerCreateUpdateRequest) {
        return beerService.updateBeer(beerCreateUpdateRequest);
    }

    @PutMapping("/updateBeerDiscount")
    public String updateBeerDiscount(@RequestBody BeerDiscountCreateUpdateRequest beerDiscountCreateUpdateRequest) {
        return beerService.updateBeerDiscount(beerDiscountCreateUpdateRequest);
    }

}
