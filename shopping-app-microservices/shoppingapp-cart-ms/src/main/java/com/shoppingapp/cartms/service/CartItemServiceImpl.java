package com.shoppingapp.cartms.service;

import com.shoppingapp.cartms.model.CartItem;
import com.shoppingapp.cartms.model.Product;
import com.shoppingapp.cartms.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {


    private CartItemRepository cartItemRepository;

    private RestTemplate restTemplate;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, RestTemplate restTemplate){
        this.cartItemRepository = cartItemRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public CartItem addProductToCart(String productId, int quantity) {
        // fetch product from product service
        Product product = null;

        product = restTemplate.getForObject("http://localhost:5100/api/products/" + productId, Product.class);

        // create cart item
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setProductName(product.getName());
        cartItem.setPrice(product.getPrice());
        cartItem.setQuantity(quantity);

        // save cart item
        return cartItemRepository.save(cartItem);

    }

    @Override
    public CartItem updateProductInCart(String productId, int quantity) {
        return null;
    }

    @Override
    public void deleteProductFromCart(String productId) {

    }

    @Override
    public void deleteAllProductsFromCart() {

    }

    @Override
    public List<CartItem> getAllProductsFromCart() {
        return cartItemRepository.findAll();
    }
}
