package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.dtos.BeerDiscountRequest;
import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.services.BeerService;

@RestController
@RequestMapping("/beers")
public class BeerController {

    public final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/getAll")
    public List<BeerWithDiscount> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/getDiscounts")
    public List<BeerWithDiscount> getBeerDiscount(@RequestBody List<BeerDiscountRequest> beerDiscountRequests) {
        return beerService.getDiscount(beerDiscountRequests);
    }

}
