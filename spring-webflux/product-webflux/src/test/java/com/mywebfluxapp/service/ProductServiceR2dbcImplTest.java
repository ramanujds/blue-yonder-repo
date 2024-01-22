package com.mywebfluxapp.service;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.repository.ProductRepository;
import com.mywebfluxapp.util.EntityDtoUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceR2dbcImplTest {

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductServiceR2dbcImpl productService;

    @Test
    public void testGetProductById(){

        // Given
        ProductDto product = new ProductDto(1,"iPhone 15","Apple iPhone 15",78000);

        // When
        Mockito.when(productRepo.findById(product.id())).thenReturn(Mono.just(EntityDtoUtil.getProductEntity(product)));

        // Then
        StepVerifier.create(productService.getProductById(product.id()))
                .expectSubscription()
                .expectNext(product)
                .verifyComplete();


    }

    @Test
    public void testGetAllProducts(){

        // Given
        ProductDto product1 = new ProductDto(1,"iPhone 15","Apple iPhone 15",78000);
        ProductDto product2 = new ProductDto(2,"iPhone 16","Apple iPhone 16",88000);
        ProductDto product3 = new ProductDto(3,"iPhone 17","Apple iPhone 17",98000);
        ProductDto product4 = new ProductDto(4,"iPhone 18","Apple iPhone 18",108000);

        List<ProductDto> productDtoList = List.of(product1,product2,product3,product4);

        // When
        Mockito.when(productRepo.findAll())
                .thenReturn(
                        Flux.fromStream(
                                productDtoList.stream().map(EntityDtoUtil::getProductEntity))
                );

        // Then

        StepVerifier.create(productService.getAllProducts())
                .expectSubscription()
                .expectNext(product1,product2,product3,product4)
                .verifyComplete();



    }



}
