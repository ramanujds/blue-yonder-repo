package com.shoppingapp.orderms.service;

import com.shoppingapp.orderms.dto.CartDetails;
import com.shoppingapp.orderms.model.CartItem;
import com.shoppingapp.orderms.model.OrderDetails;
import com.shoppingapp.orderms.model.OrderStatus;
import com.shoppingapp.orderms.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private RestTemplate restTemplate;

    private String cartServiceUrl = "http://CART-MS/api/cart";

    @Autowired
    private OrderDetailsRepository orderRepo;

    @Override
    public OrderDetails placeOrder() {

CartDetails cartDetails = getCartDetails();
        if(cartDetails != null) {
            float totalCartValue = calculateTotalCartValue(cartDetails);
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderedItems(cartDetails.items());
            orderDetails.setTotalAmount(totalCartValue);
            orderDetails.setOrderStatus(OrderStatus.ORDER_PLACED);
            orderDetails.setOrderDate(LocalDateTime.now());
            orderRepo.save(orderDetails);
            return orderDetails;
        }

        return null;
    }

    private CartDetails getCartDetails() {
        return restTemplate.getForObject(cartServiceUrl, CartDetails.class);
    }

    private float calculateTotalCartValue(CartDetails cartDetails){
        List<CartItem> cartItems = cartDetails.items();
        float totalCartValue = 0;
        for(CartItem cartItem : cartItems) {
            totalCartValue += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalCartValue;
    }
}
