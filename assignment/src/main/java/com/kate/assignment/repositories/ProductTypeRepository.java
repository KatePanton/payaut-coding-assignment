package com.kate.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kate.assignment.models.entities.ProductTypes;
import com.kate.assignment.models.interfaces.ProductTypeInterface;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypes, Integer> {

        @Query(nativeQuery = true, value = "SELECT product_type_id, product_type_name " +
                        "FROM product_types " +
                        "WHERE ?1 == product_type_name ")
        public List<ProductTypeInterface> getAllProductTypes();

        @Query(nativeQuery = true, value = "SELECT product_type_id, product_type_name " +
                        "FROM product_types " +
                        "WHERE ?1 == product_type_name " +
                        "LIMIT 1 ")
        public ProductTypeInterface getProductTypeByName(String productTypeName);

}
