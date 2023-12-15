package com.shoppingapp.productms.repository;

import com.shoppingapp.productms.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {


    public Product findByNameIgnoreCase(String name);

}
