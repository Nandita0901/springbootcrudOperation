package com.springBootApi.CrudOperationProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springBootApi.CrudOperationProject.Service.ProductService;
import com.springBootApi.CrudOperationProject.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products with pagination
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return productService.getAllProducts(page, size);
    }

    // Create a new product and associate it with a category
    @PostMapping
    public Product createProduct(@RequestBody Product product, @RequestParam Long categoryId) {
        return productService.createProduct(product, categoryId);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Update a product by ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, 
                                 @RequestBody Product product, 
                                 @RequestParam(required = false) Long categoryId) {
        return productService.updateProduct(id, product, categoryId);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
