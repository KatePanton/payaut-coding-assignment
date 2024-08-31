package com.kate.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.models.dtos.BreadWithDiscount;
import com.kate.assignment.models.dtos.OrderRequest;
import com.kate.assignment.models.dtos.OrderWithDiscounts;
import com.kate.assignment.models.dtos.VegWithDiscount;

@Service
public class OrderService {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BreadService breadService;

    @Autowired
    private VegService vegService;

    public OrderWithDiscounts getOrderWithDiscounts(List<OrderRequest> orderRequests) {

        OrderWithDiscounts orderWithDiscounts = new OrderWithDiscounts();

        // Initialize the lists
        orderWithDiscounts.beerWithDiscounts = new ArrayList<>();
        orderWithDiscounts.breadWithDiscounts = new ArrayList<>();
        orderWithDiscounts.vegWithDiscounts = new ArrayList<>();
        orderWithDiscounts.TotalAmountPayable = 0;

        for (var orderRequest : orderRequests) {

            if (orderRequest.getBeerDiscountRequests() != null) {
                List<BeerWithDiscount> beerWithDiscounts = beerService
                        .getDiscount(orderRequest.getBeerDiscountRequests());
                orderWithDiscounts.beerWithDiscounts.addAll(beerWithDiscounts);

                for (var beerWithDiscount : beerWithDiscounts) {
                    orderWithDiscounts.TotalAmountPayable = orderWithDiscounts.TotalAmountPayable.doubleValue()
                            + beerWithDiscount.AmountPayable.doubleValue();
                }

            }

            if (orderRequest.getBreadDiscountRequests() != null) {
                List<BreadWithDiscount> breadWithDiscounts = breadService
                        .getDiscount(orderRequest.getBreadDiscountRequests());
                orderWithDiscounts.breadWithDiscounts.addAll(breadWithDiscounts);

                for (var breadWithDiscount : breadWithDiscounts) {
                    orderWithDiscounts.TotalAmountPayable = orderWithDiscounts.TotalAmountPayable.doubleValue()
                            + breadWithDiscount.AmountPayable.doubleValue();
                }
            }

            if (orderRequest.getVegDiscountRequests() != null) {
                List<VegWithDiscount> vegWithDiscounts = vegService.getDiscount(orderRequest.getVegDiscountRequests());
                orderWithDiscounts.vegWithDiscounts.addAll(vegWithDiscounts);

                for (var vegWithDiscount : vegWithDiscounts) {
                    orderWithDiscounts.TotalAmountPayable = orderWithDiscounts.TotalAmountPayable.doubleValue()
                            + vegWithDiscount.AmountPayable.doubleValue();
                }
            }
        }

        return orderWithDiscounts;
    }

}
