package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kate.assignment.models.entities.Vegetables;
import com.kate.assignment.models.interfaces.VegWithDiscountInterface;

@Repository
public interface VegRepository extends JpaRepository<Vegetables, Integer> {

        String selectAllFields = "vegetables.vegetable_id, vegetables.price, " +
                        "vegetable_discounts.vegetable_discount_id, vegetable_discounts.minimum_weight, vegetable_discounts.discount_percentage ";

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM vegetables " +
                        "LEFT JOIN vegetable_discounts ON vegetables.vegetable_id = vegetable_discounts.vegetable_id")
        public List<VegWithDiscountInterface> getAllVegetables();

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM vegetables " +
                        "LEFT JOIN vegetable_discounts ON vegetables.vegetable_id = vegetable_discounts.vegetable_id " +
                        "WHERE vegetables.vegetable_id = ?1 " +
                        "AND ?2 >=  vegetable_discounts.minimum_weight " +
                        "ORDER BY vegetable_discounts.minimum_weight DESC " +
                        "LIMIT 1 ")
        public VegWithDiscountInterface getDiscountDetails(Integer vegetableId, Integer vegetableWeight);

}
