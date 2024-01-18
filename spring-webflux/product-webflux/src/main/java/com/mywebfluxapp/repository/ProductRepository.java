package com.mywebfluxapp.repository;

import com.mywebfluxapp.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

   Mono<Product> findByName(String name);

}
