package com.kate.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.BreadDiscountRequest;
import com.kate.assignment.models.dtos.BreadWithDiscount;
import com.kate.assignment.repositories.BreadRepository;

@Service
public class BreadService {

    @Autowired
    private BreadRepository breadRepository;

    public List<BreadWithDiscount> getAllBreads() {
        var holder = breadRepository.getAllBreads();

        List<BreadWithDiscount> breadWithDiscounts = holder.stream()
                .map(BreadWithDiscount::new)
                .collect(Collectors.toList());

        return breadWithDiscounts;
    }

    public List<BreadWithDiscount> getDiscount(List<BreadDiscountRequest> requests) {
        return requests.stream()
                .map(request -> determineDiscount(request.getBreadId(), request.getBreadAge()))
                .collect(Collectors.toList());
    }

    private BreadWithDiscount getDiscountDetails(Integer breadId, Integer breadAge) {
        var holder = breadRepository.getDiscountDetails(breadId, breadAge);

        BreadWithDiscount breadWithDiscount = new BreadWithDiscount(holder);
        return breadWithDiscount;
    }

    private BreadWithDiscount determineDiscount(Integer breadId, Integer breadAge) {

        var discountDetails = getDiscountDetails(breadId, breadAge);
        discountDetails.setDiscount(breadAge);

        return discountDetails;
    }
}
