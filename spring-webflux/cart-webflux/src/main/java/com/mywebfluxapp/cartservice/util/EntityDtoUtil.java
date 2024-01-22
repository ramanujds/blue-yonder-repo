package com.mywebfluxapp.cartservice.util;

import com.mywebfluxapp.cartservice.dto.CartItemDto;
import com.mywebfluxapp.cartservice.model.CartItemEntity;

public class EntityDtoUtil {

    public static CartItemDto getCartItemDto(CartItemEntity item){
        return new CartItemDto(item.getId(),item.getProductName(),item.getPrice(),item.getQuantity());
    }

    public static CartItemEntity getCartItemEntity(CartItemDto item){
        return new CartItemEntity(item.id(),item.name(),item.price(),item.quantity());
    }

}
