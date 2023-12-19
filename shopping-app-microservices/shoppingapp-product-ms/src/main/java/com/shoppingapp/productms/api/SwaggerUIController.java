package com.shoppingapp.productms.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/products")
public class SwaggerUIController {

    @GetMapping("/swagger-ui")
    public String openSwaggerUi(){
        return "/swagger-ui.html";
    }

}
