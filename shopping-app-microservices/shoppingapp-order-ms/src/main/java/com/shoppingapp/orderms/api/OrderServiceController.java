package com.shoppingapp.orderms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderServiceController {

    @GetMapping
    public String sayHello(){
        return "Hello your order is getting processed";
    }

}
