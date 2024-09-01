package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.dtos.ProductType;
import com.kate.assignment.models.entities.ProductTypes;
import com.kate.assignment.services.ProductTypeService;

@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {

    public final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/getAll")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/getByName")
    public ProductTypes getProductTypeByName(String productTypeName) {
        return productTypeService.getProductTypeByName(productTypeName);
    }

}
