package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kate.assignment.models.dtos.BeerWithDiscount;
import com.kate.assignment.models.entities.Beers;

@Repository
public interface BeerRepository extends JpaRepository<Beers, Integer> {

    @Query(nativeQuery = true, value = "SELECT " +
            "beers.beer_id, beers.brand, beers.price, " +
            "beer_discounts.beer_discount_id, beer_discounts.bottles_required, beer_discounts.discount_amount " +
            "FROM beers " +
            "LEFT JOIN beer_discounts ON beers.beer_id = beer_discounts.beer_id")
    public List<BeerWithDiscount> getAllBeers();

    @Query(nativeQuery = true, value = "SELECT " +
            "beers.beer_id, beer_discounts.bottles_required, beer_discounts.discount_amount " +
            "FROM beers " +
            "LEFT JOIN beer_discounts ON beers.beer_id = beer_discounts.beer_id " +
            "WHERE beers.beer_id = ?1 ")
    public BeerWithDiscount getDiscountDetails(Integer beerId);
}
