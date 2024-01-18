package com.mywebfluxapp.service;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.util.DelayUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface ProductService {

    public Mono<ProductDto> getProductById(int id) ;
    public Flux<ProductDto> getAllProducts();


    public Mono<ProductDto> saveProduct(Mono<ProductDto> product);

    public Mono<ProductDto> updateProduct(Mono<ProductDto> product);

    public Mono<Void> deleteProduct(int id);

    public Mono<ProductDto> findProductByName(String name);




}
