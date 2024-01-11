package com.shoppingapp.productms.service;

import com.shoppingapp.productms.model.Product;
import com.shoppingapp.productms.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void createProductTest(){

        // Given
        Product product = new Product();
        product.setId("1");
        product.setName("iPhone 15");
        product.setDescription("iPhone 15 128GB");
        product.setPrice(79000);

        // When
        when(productRepository.save(product)).thenReturn(product);
        when(productRepository.existsById(product.getId())).thenReturn(false);
        // Then
        assertEquals(product,productService.createProduct(product));

        // Verify
        verify(productRepository,times(1)).save(product);


    }

    @Test
    public void createProductTestForException(){

        // Given
        Product product = new Product();
        product.setId("1");
        product.setName("iPhone 15");
        product.setDescription("iPhone 15 128GB");
        product.setPrice(79000);

        // When
        when(productRepository.existsById(product.getId())).thenReturn(true);
        // Then
        assertThrows(RuntimeException.class,()->productService.createProduct(product));
        // Verify
        verify(productRepository,times(1)).existsById(product.getId());


    }

}
