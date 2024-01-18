package com.mywebfluxapp.util;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.entity.Product;

public class EntityDtoUtil {

    public static ProductDto getProductDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getDescription(),product.getPrice());
    }

    public static Product getProductEntity(ProductDto productDto){
        return new Product(productDto.id(),productDto.name(),productDto.description(),productDto.price());
    }

}
