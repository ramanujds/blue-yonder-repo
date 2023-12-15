package com.shoppingapp.productms.api;

import com.shoppingapp.productms.model.Product;
import com.shoppingapp.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Product getProductById(@PathVariable String id){
        return productService.findProductById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK)
    public Product getProductByName(@RequestParam("name") String name){
        return productService.findProductByName(name);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Product updateProduct(@PathVariable String id, @RequestBody Product product){
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }



}
