package com.mywebfluxapp.api;

import com.mywebfluxapp.dto.ProductDto;
import com.mywebfluxapp.service.ProductService;
import com.mywebfluxapp.service.ProductServiceR2dbcImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = {ProductController.class})
@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    ProductService productService;

    @Test
    public void testGetProductById(){
        // Given
        ProductDto productDto = new ProductDto(1,"Samsung S24 Ultra","Samsung's new launch",131000);

        // When
        Mockito.when(productService.getProductById(productDto.id())).thenReturn(Mono.just(productDto));

        // Then

        webTestClient.get()
                .uri("/api/products/"+productDto.id())
                .exchange()
                .expectStatus().isOk()
                .expectBody(ProductDto.class)
                .isEqualTo(productDto);

        // Verify
        Mockito.verify(productService,Mockito.times(1)).getProductById(productDto.id());



    }


    @Test
    public void testAddProduct(){
        // Given
        ProductDto productDto = new ProductDto(1,"Samsung S24 Ultra","Samsung's new launch",131000);

        // When
        Mockito.when(productService.saveProduct(Mono.just(productDto))).thenReturn(Mono.just(productDto));


        // Then

        webTestClient.post()
                .uri("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(productDto),ProductDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ProductDto.class)
  //             .isEqualTo(productDto);
                ;

        // Verify
      //  Mockito.verify(productService,Mockito.times(1)).getProductById(productDto.id());



    }


    // For streaming apis

    // .expectHeader().contentTypeCompatibleWith("text/event-stream")

    // For Delete

    //  Mockito.when(productService.deleteProduct(1)).thenReturn(Mono.empty());
    //

}
