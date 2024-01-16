package com.mywebfluxapp.api;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.service.ProductService;
import com.mywebfluxapp.service.ProductServiceReactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/products/reactive")
public class ProductControllerReactive {

    private ProductServiceReactive productService;


    @Autowired
    public ProductControllerReactive(ProductServiceReactive productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable int id){
       return productService.getProductById(id);
    }

    @GetMapping(produces = "text/event-stream")
    public Flux<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }


}
