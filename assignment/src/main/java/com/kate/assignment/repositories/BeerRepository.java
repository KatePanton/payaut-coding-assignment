package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
                        "WHERE beers.beer_id = ?1 OR beers.brand = ?2")
        public BeerWithDiscountInterface getDiscountDetails(Integer beerId, String brand);

        // @Modifying
        // @Query(nativeQuery = true, value = "UPDATE beer_discounts " +
        // "SET bottles_required = :bottlesRequired, discount_amount = :discountAmount "
        // +
        // "WHERE beer_discount_id = :discountId")
        // public BeerWithDiscount updateBeerDiscount(
        // @Param("discountId") Integer discountId,
        // @Param("bottlesRequired") Integer bottlesRequired,
        // @Param("discountAmount") Double discountAmount);

        @Modifying
        @Query(nativeQuery = true, value = "INSERT INTO beers (price, brand, product_type_id) " +
                        "VALUES (:price, :brand, :product_type_id) ")
        void addNewBeer(
                        @Param("price") Number price,
                        @Param("brand") String brand,
                        @Param("product_type_id") Integer product_type_id);

}
