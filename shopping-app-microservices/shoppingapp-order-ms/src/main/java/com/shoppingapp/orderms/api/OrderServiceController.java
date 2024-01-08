package com.shoppingapp.orderms.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderServiceController {

    @Value("${message: Default Hello}")
    private String message;

    @GetMapping
    public String sayHello(){
        return message;
    }

}
