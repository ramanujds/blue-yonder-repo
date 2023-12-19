package com.shoppingapp.cartms.api;

import com.shoppingapp.cartms.dto.CartDetails;
import com.shoppingapp.cartms.model.CartItem;
import com.shoppingapp.cartms.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService){
        this.cartItemService = cartItemService;
    }

    @PostMapping("/products/{productId}/quantity/{quantity}")
    public CartDetails addProductToCart(@PathVariable String productId, @PathVariable int quantity){
        return cartItemService.addProductToCart(productId, quantity);
    }

    @GetMapping
    public CartDetails getAllProductsFromCart(){
        return cartItemService.getAllProductsFromCart();
    }



}
