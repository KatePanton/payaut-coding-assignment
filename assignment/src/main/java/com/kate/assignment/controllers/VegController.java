package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.dtos.VegWithDiscount;
import com.kate.assignment.models.dtos.VegDiscountRequest;
import com.kate.assignment.services.VegService;

@RestController
@RequestMapping("/vegetables")
public class VegController {

    public final VegService vegetableService;

    public VegController(VegService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/getAll")
    public List<VegWithDiscount> getAllVegetables() {
        return vegetableService.getAllVegetables();
    }

    @GetMapping("/getDiscounts")
    public List<VegWithDiscount> getVegetableDiscount(
            @RequestBody List<VegDiscountRequest> vegetableDiscountRequests) {
        return vegetableService.getDiscount(vegetableDiscountRequests);
    }
}