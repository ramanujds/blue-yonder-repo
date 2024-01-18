package com.mywebfluxapp.config;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.service.ProductServiceCollectionBasedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductApiRequestHandler {

    @Autowired
    private ProductServiceCollectionBasedImpl productService;

    public Mono<ServerResponse> getAllProductsHandler(ServerRequest request){
        Flux<ProductDto> products = productService.getAllProducts();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(products, ProductDto.class);
    }



}
