package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.dtos.BreadDiscountRequest;
import com.kate.assignment.models.dtos.BreadWithDiscount;
import com.kate.assignment.services.BreadService;

@RestController
@RequestMapping("/breads")
public class BreadController {

    public final BreadService breadService;

    public BreadController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping("/getAll")
    public List<BreadWithDiscount> getAllBreads() {
        return breadService.getAllBreads();
    }

    @GetMapping("/getDiscounts")
    public List<BreadWithDiscount> getBreadDiscount(@RequestBody List<BreadDiscountRequest> breadDiscountRequests) {
        return breadService.getDiscount(breadDiscountRequests);
    }
}
