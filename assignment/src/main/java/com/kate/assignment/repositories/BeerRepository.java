package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kate.assignment.models.entities.Beers;
import com.kate.assignment.models.interfaces.BeerInterface;
import com.kate.assignment.models.interfaces.BeerWithDiscountInterface;

@Repository
public interface BeerRepository extends JpaRepository<Beers, Integer> {

        String selectAllFields = "beers.beer_id, beers.price, beers.brand, " +
                        "beer_discounts.beer_discount_id, beer_discounts.bottles_required, beer_discounts.discount_amount ";

        // Add
        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "INSERT INTO beers (price, brand, product_type_id) " +
                        "VALUES (:price, :brand, :product_type_id) ")
        void addNewBeer(
                        @Param("price") Number price,
                        @Param("brand") String brand,
                        @Param("product_type_id") Integer product_type_id);

        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "INSERT INTO beer_discounts (bottles_required, discount_amount, beer_id) " +
                        "VALUES (:bottles_required, :discount_amount, :beer_id) ")
        void addNewBeerDiscount(
                        @Param("bottles_required") Number bottles_required,
                        @Param("discount_amount") Number discount_amount,
                        @Param("beer_id") Integer beer_id);

        // Get
        @Query(nativeQuery = true, value = "SELECT beer_id, price, brand " +
                        "FROM beers " +
                        "WHERE brand ==?1 " +
                        "LIMIT 1 ")
        public BeerInterface getBeerByBrand(String brand);

        @Query(nativeQuery = true, value = "SELECT " +
                        selectAllFields +
                        "FROM beers " +
                        "LEFT JOIN beer_discounts ON beers.beer_id = beer_discounts.beer_id " +
                        "WHERE beers.brand = ?1 ")
        public BeerWithDiscountInterface getBeerDiscountByBrand(String brand);

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

        // Update
        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "UPDATE beers " +
                        "SET price = :price, brand = :brand, product_type_id = :product_type_id "
                        +
                        "WHERE beer_id = :beer_id ")
        void updateBeer(
                        @Param("beer_id") Integer beer_id,
                        @Param("price") Number price,
                        @Param("brand") String brand,
                        @Param("product_type_id") Integer product_type_id);

        @Transactional
        @Modifying
        @Query(nativeQuery = true, value = "UPDATE beer_discounts " +
                        "SET bottles_required = :bottles_required, discount_amount = :discount_amount, beer_id = :beer_id "
                        +
                        "WHERE beer_discount_id = :discount_id ")
        void updateBeerDiscount(
                        @Param("discount_id") Integer discount_id,
                        @Param("bottles_required") Integer bottles_required,
                        @Param("discount_amount") Double discount_amount,
                        @Param("beer_id") Integer beer_id);

}
