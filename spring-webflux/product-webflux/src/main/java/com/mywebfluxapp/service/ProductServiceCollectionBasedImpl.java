package com.mywebfluxapp.service;

import com.mywebfluxapp.dto.ProductDto;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class ProductServiceCollectionBasedImpl implements ProductService {

    private List<ProductDto> productList;

    @PostConstruct
    void setupProducts() {
        productList = List.of(
                new ProductDto(1, "iPhone 15", "Apple iPhone 15 128GB", 79000.0f),
                new ProductDto(2, "iPhone 14", "Apple iPhone 14 128GB", 69000.0f),
                new ProductDto(3, "Macbook Pro", "Apple Macbook Pro 16 with 512GB Storage, 16 GB RAM", 200000.0f),
                new ProductDto(4, "Macbook Air", "Apple Macbook Air 13 with 256GB Storage, 8 GB RAM", 100000.0f),
                new ProductDto(5, "iPad Pro", "Apple iPad Pro 12.9 with 256GB Storage, 8 GB RAM", 80000.0f)
        );

    }

    public Mono<ProductDto> getProductById(int id) {

        // return Mono.just(productList.stream().filter(p->p.id()==id).findFirst().get());

        return Mono.fromSupplier(() -> productList.stream()
                .filter(p -> p.id() == id).findFirst().orElse(null));

    }

    public Flux<ProductDto> getAllProducts() {
        return Flux.fromIterable(productList)
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(p -> log.info("Processing Product {}", p))
                .doOnCancel(() -> log.info("Processing Cancelled"))
                .doOnComplete(() -> log.info("Processing Completed"));

    }

    @Override
    public Mono<ProductDto> saveProduct(Mono<ProductDto> product) {
        return null;
    }

    @Override
    public Mono<ProductDto> updateProduct(Mono<ProductDto> product) {
        return null;
    }

    @Override
    public Mono<Void> deleteProduct(int id) {
        return null;
    }

    @Override
    public Mono<ProductDto> findProductByName(String name) {
        return null;
    }


}
