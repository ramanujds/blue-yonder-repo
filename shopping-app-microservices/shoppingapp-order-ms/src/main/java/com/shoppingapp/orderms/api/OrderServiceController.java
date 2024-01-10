package com.shoppingapp.orderms.api;

import com.shoppingapp.orderms.model.OrderDetails;
import com.shoppingapp.orderms.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/api/orders")
public class OrderServiceController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Value("${message: No Message available}")
    private String message;

    @GetMapping("/message")
    public String sayHello(){
        return message;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDetails placeOrder(){

        return orderDetailsService.placeOrder();

    }

}
