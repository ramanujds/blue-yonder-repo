package com.mywebfluxapp.service;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.util.DelayUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private List<ProductDto> productList;

    @PostConstruct
    void setupProducts(){
        productList = List.of(
                new ProductDto(1,"iPhone 15","Apple iPhone 15 128GB", 79000.0f),
                new ProductDto(2,"iPhone 14","Apple iPhone 14 128GB", 69000.0f),
                new ProductDto(3,"Macbook Pro","Apple Macbook Pro 16 with 512GB Storage, 16 GB RAM", 200000.0f),
                new ProductDto(4,"Macbook Air","Apple Macbook Air 13 with 256GB Storage, 8 GB RAM", 100000.0f),
                new ProductDto(5,"iPad Pro","Apple iPad Pro 12.9 with 256GB Storage, 8 GB RAM", 80000.0f)
        );

    }

    public ProductDto getProductById(int id){
       return productList.stream().filter(p->p.id()==id).findFirst().orElse(null);
    }

    public List<ProductDto> getAllProducts(){
        return productList.stream()
                .peek(p -> DelayUtil.delay(2))
                .peek(p -> log.info("Processing Product {}",p))
                .toList();

    }


}
