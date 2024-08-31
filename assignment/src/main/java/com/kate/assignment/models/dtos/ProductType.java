package com.kate.assignment.models.dtos;

import com.kate.assignment.models.interfaces.ProductTypeInterface;

public class ProductType {
    public Integer ProductTypeId;

    public String ProductTypeName;

    public ProductType(ProductTypeInterface productTypeInterface) {
        this.ProductTypeId = productTypeInterface.getProductTypeId();
        this.ProductTypeName = productTypeInterface.getProductTypeName();
    }
}
