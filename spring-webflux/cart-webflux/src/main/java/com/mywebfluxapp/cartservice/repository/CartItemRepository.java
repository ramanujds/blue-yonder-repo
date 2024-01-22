package com.mywebfluxapp.cartservice.repository;

import com.mywebfluxapp.cartservice.model.CartItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartItemRepository extends ReactiveCrudRepository<CartItemEntity,Integer> {
}
