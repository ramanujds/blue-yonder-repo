package com.mywebfluxapp.service;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.entity.Product;
import com.mywebfluxapp.exception.ProductNotFoundException;
import com.mywebfluxapp.repository.ProductRepository;
import com.mywebfluxapp.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Primary
@Slf4j
public class ProductServiceR2dbcImpl implements ProductService {

//    @Autowired
//    Environment env;

    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public ProductServiceR2dbcImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<ProductDto> getProductById(int id) {
        return productRepository.findById(id).switchIfEmpty(Mono.error(new ProductNotFoundException("Product with ID " + id + " Not Found")))
                .map(EntityDtoUtil::getProductDto);
    }

    @Override
    public Flux<ProductDto> getAllProducts() {

        return productRepository.findAll().map(EntityDtoUtil::getProductDto);
    }

    @Override
    public Mono<ProductDto> saveProduct(Mono<ProductDto> product) {

        return product.map(EntityDtoUtil::getProductEntity)
                .flatMap(p -> productRepository.save(p))
                .map(EntityDtoUtil::getProductDto);

    }

    @Override
    public Mono<ProductDto> updateProduct(Mono<ProductDto> product) {
        return product.map(EntityDtoUtil::getProductEntity)
                .flatMap(p -> productRepository.findById(p.getId())
                            .switchIfEmpty(Mono.error(new ProductNotFoundException("Product with ID " + p.getId() + " Not Found")))
                            .flatMap(pr -> productRepository.save(pr))
                            .map(EntityDtoUtil::getProductDto));
                }

        @Override
        public Mono<Void> deleteProduct ( int id){
            return productRepository.deleteById(id);
        }

        @Override
        public Mono<ProductDto> findProductByName (String name){
            return productRepository.findByName(name).map(EntityDtoUtil::getProductDto);
        }
    }
