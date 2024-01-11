package com.shoppingapp.productms.service;

import com.shoppingapp.productms.model.Product;
import com.shoppingapp.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductServiceImpl(){

    }

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product){
        if(productRepository.existsById(product.getId())){
            throw new RuntimeException("Duplicate Product");
        }
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(String id){
        return productRepository.findById(id).orElse(null);
    }

    @Override

    public Product findProductByName(String name){
        return productRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}
