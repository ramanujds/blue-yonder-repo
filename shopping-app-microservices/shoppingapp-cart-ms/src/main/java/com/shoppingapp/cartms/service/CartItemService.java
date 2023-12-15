package com.shoppingapp.cartms.service;

import com.shoppingapp.cartms.model.CartItem;

import java.util.List;

public interface CartItemService {

    public CartItem addProductToCart(String productId, int quantity);

    public CartItem updateProductInCart(String productId, int quantity);

    public void deleteProductFromCart(String productId);

    public void deleteAllProductsFromCart();

    public List<CartItem> getAllProductsFromCart();

}
