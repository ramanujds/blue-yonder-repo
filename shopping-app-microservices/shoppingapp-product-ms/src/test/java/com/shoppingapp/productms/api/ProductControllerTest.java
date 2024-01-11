package com.shoppingapp.productms.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingapp.productms.model.Product;
import com.shoppingapp.productms.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    public void testGetProductById() throws Exception {

        // Given
        Product product = new Product();
        product.setId("1");
        product.setName("iPhone 15");
        product.setDescription("iPhone 15 128GB");
        product.setPrice(79000);

        // When
        when(productService.findProductById(product.getId())).thenReturn(product);

        // Then
        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("iPhone 15"))
                .andExpect(jsonPath("$.price").value(79000))
                .andExpect(jsonPath("$.description").value("iPhone 15 128GB"))
                .andReturn();

        // Verify

        verify(productService,times(1)).findProductById(product.getId());


    }

    public void testCreateProduct() throws Exception{

            // Given
            Product product = new Product();
            product.setId("1");
            product.setName("iPhone 15");
            product.setDescription("iPhone 15 128GB");
            product.setPrice(79000);

            // When
            when(productService.createProduct(product)).thenReturn(product);

            // Then
            mockMvc.perform(post("/api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapToJson(product)))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value("1"))
                    .andExpect(jsonPath("$.name").value("iPhone 15"))
                    .andExpect(jsonPath("$.price").value(79000))
                    .andExpect(jsonPath("$.description").value("iPhone 15 128GB"))
                    .andReturn();

            // Verify

            verify(productService,times(1)).createProduct(product);
    }




    // create a helper method to convert object to json string
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


}
