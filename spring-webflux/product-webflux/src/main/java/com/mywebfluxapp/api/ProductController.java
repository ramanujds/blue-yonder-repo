package com.mywebfluxapp.api;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.service.ProductService;
import com.mywebfluxapp.service.ProductServiceCollectionBasedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// ab -n 100 -c 100 http://localhost:5100/api/products/reactive

@RestController
@RequestMapping("/api/products/reactive")
public class ProductController {

    private ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
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

    @PostMapping
    public Mono<ProductDto> addProduct(@RequestBody Mono<ProductDto> product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @PutMapping
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> product){
        return productService.updateProduct(product);
    }

    @GetMapping("/name/{name}")
    public Mono<ProductDto> getProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }




}
