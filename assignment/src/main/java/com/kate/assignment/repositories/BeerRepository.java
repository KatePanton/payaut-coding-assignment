package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kate.assignment.models.entities.Beers;
import com.kate.assignment.models.interfaces.BeerWithDiscountInterface;

@Repository
public interface BeerRepository extends JpaRepository<Beers, Integer> {

        String selectAllFields = "beers.beer_id, beers.price, beers.brand, " +
                        "beer_discounts.beer_discount_id, beer_discounts.bottles_required, beer_discounts.discount_amount ";

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM beers " +
                        "LEFT JOIN beer_discounts ON beers.beer_id = beer_discounts.beer_id")
        public List<BeerWithDiscountInterface> getAllBeers();

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM beers " +
                        "LEFT JOIN beer_discounts ON beers.beer_id = beer_discounts.beer_id " +
                        "WHERE beers.beer_id = ?1 ")
        public BeerWithDiscountInterface getDiscountDetails(Integer beerId);

}
