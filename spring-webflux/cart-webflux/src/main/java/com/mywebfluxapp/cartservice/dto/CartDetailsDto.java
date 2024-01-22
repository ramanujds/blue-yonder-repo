package com.mywebfluxapp.cartservice.dto;

import reactor.core.publisher.Flux;

import java.util.List;

public record CartDetailsDto(List<CartItemDto> cartItems, float total) {
}
