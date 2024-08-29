package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.VegDiscountRequest;
import com.kate.assignment.models.dtos.VegWithDiscount;
import com.kate.assignment.repositories.VegRepository;

@Service
public class VegService {

    @Autowired
    private VegRepository vegetableRepository;

    public List<VegWithDiscount> getAllVegetables() {
        var holder = vegetableRepository.getAllVegetables();

        List<VegWithDiscount> vegetableWithDiscounts = holder.stream()
                .map(VegWithDiscount::new)
                .collect(Collectors.toList());

        return vegetableWithDiscounts;
    }

    public List<VegWithDiscount> getDiscount(List<VegDiscountRequest> requests) {
        return requests.stream()
                .map(request -> determineDiscount(request.getVegetableId(), request.getVegetableWeight()))
                .collect(Collectors.toList());
    }

    private VegWithDiscount getDiscountDetails(Integer vegetableId, Integer vegetableWeight) {
        var holder = vegetableRepository.getDiscountDetails(vegetableId, vegetableWeight);

        VegWithDiscount vegetableWithDiscount = new VegWithDiscount(holder);
        return vegetableWithDiscount;
    }

    private VegWithDiscount determineDiscount(Integer vegetableId, Integer vegetableWeight) {

        var discountDetails = getDiscountDetails(vegetableId, vegetableWeight);
        discountDetails.setDiscount(vegetableWeight, discountDetails.DiscountPercentage);

        return discountDetails;
    }

}
