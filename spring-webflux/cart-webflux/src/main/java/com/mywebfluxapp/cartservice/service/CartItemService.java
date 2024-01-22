package com.mywebfluxapp.cartservice.service;

import com.mywebfluxapp.cartservice.dto.CartDetailsDto;
import com.mywebfluxapp.cartservice.dto.CartItemDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartItemService {


    public Mono<CartItemDto> addCartItem(int productId, int quantity);

    public Mono<CartDetailsDto> getAllCartItems();

}
