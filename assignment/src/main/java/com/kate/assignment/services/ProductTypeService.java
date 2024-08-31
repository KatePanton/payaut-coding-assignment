package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.ProductType;
import com.kate.assignment.models.entities.ProductTypes;
import com.kate.assignment.models.interfaces.ProductTypeInterface;
import com.kate.assignment.repositories.ProductTypeRepository;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getAllProductTypes() {
        var holder = productTypeRepository.getAllProductTypes();

        List<ProductType> productTypes = holder.stream()
                .map(ProductType::new)
                .collect(Collectors.toList());

        return productTypes;
    }

    public ProductTypes getProductTypeByName(String productTypeName) {

        ProductTypeInterface result = productTypeRepository.getProductTypeByName(productTypeName);
        ProductTypes productType = new ProductTypes(result);

        return productType;
    }
}
