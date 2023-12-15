package com.shoppingapp.productms.service;

import com.shoppingapp.productms.model.Product;

import java.util.List;

public interface ProductService {


    public Product createProduct(Product product);


    public Product findProductById(String id);

    public Product findProductByName(String name);


    public Product updateProduct(Product product);


    public void deleteProduct(String id);


    public List<Product> getAllProducts();

}
