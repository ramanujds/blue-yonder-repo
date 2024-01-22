package com.mywebfluxapp.cartservice.api;

import com.mywebfluxapp.cartservice.dto.CartDetailsDto;
import com.mywebfluxapp.cartservice.dto.CartItemDto;
import com.mywebfluxapp.cartservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cart")
public class CartDetailsController {


    private CartItemService cartItemService;

    @Autowired
    public CartDetailsController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/product/{id}/quantity/{quantity}")
    public Mono<CartItemDto> addItemToCart(@PathVariable int id, @PathVariable int quantity){
        return cartItemService.addCartItem(id,quantity);
    }

    @GetMapping
    public Mono<CartDetailsDto> getAllCartItems(){
        return cartItemService.getAllCartItems();
    }

}
