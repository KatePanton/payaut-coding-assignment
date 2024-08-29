package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kate.assignment.models.entities.Breads;
import com.kate.assignment.models.interfaces.BreadWithDiscountInterface;

@Repository
public interface BreadRepository extends JpaRepository<Breads, Integer> {

        String selectAllFields = "breads.bread_id, breads.price, " +
                        "bread_discounts.bread_discount_id, bread_discounts.max_age, bread_discounts.extra_quantity ";

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM breads " +
                        "LEFT JOIN bread_discounts ON breads.bread_id = bread_discounts.bread_id")
        public List<BreadWithDiscountInterface> getAllBreads();

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM breads " +
                        "LEFT JOIN bread_discounts ON breads.bread_id = bread_discounts.bread_id " +
                        "WHERE breads.bread_id = ?1 " +
                        "AND bread_discounts.max_age >= ?2 " +
                        "ORDER BY bread_discounts.max_age ASC " +
                        "LIMIT 1")
        public BreadWithDiscountInterface getDiscountDetails(Integer breadId, Integer breadAge);

}
