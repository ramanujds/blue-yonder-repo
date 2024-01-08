package com.shoppingapp.cartms.service;

import com.shoppingapp.cartms.dto.CartDetails;
import com.shoppingapp.cartms.model.CartItem;
import com.shoppingapp.cartms.model.Product;
import com.shoppingapp.cartms.repository.CartItemRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class CartItemServiceImpl implements CartItemService {


    private CartItemRepository cartItemRepository;

    private RestTemplate restTemplate;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, RestTemplate restTemplate){
        this.cartItemRepository = cartItemRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    @CircuitBreaker(fallbackMethod = "addProductToCartFallback", name = "cb-product-ms")
    @Retry(fallbackMethod = "addProductToCartFallback", name = "retry-product-fetch")
    public CartDetails addProductToCart(String productId, int quantity) {
        // fetch product from product service
        Product product = null;

        product = restTemplate.getForObject("http://PRODUCT-MS/api/products/" + productId, Product.class);

        // create cart item
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setProductName(product.getName());
        cartItem.setPrice(product.getPrice());
        cartItem.setQuantity(quantity);

        CartItem item = cartItemRepository.save(cartItem);

       // float total = quantity * product.getPrice();

        List<CartItem> items = cartItemRepository.findAll();

        float total = fetchTotalCartValue(items);

        CartDetails details= new CartDetails(items,total);

        return details;

    }


    public CartDetails addProductToCartFallback(String productId, int quantity, Throwable error){
        log.error(error.toString());
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Service Not Available : "+error.getMessage());
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
    public CartDetails getAllProductsFromCart() {
        List<CartItem> items = cartItemRepository.findAll();

        float total = fetchTotalCartValue(items);

        CartDetails details = new CartDetails(items, total);
        return details;
    }

    private float fetchTotalCartValue(List<CartItem> items){
        float total = (float) items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
        return total;
    }
}
