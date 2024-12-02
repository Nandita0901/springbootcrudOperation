package com.springBootApi.CrudOperationProject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springBootApi.CrudOperationProject.Repository.CategoryRepository;
import com.springBootApi.CrudOperationProject.Repository.ProductRepository;
import com.springBootApi.CrudOperationProject.entity.Category;
import com.springBootApi.CrudOperationProject.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Fetch all products with pagination
    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    // Create a new product and associate it with a category
    public Product createProduct(Product product, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }

    // Fetch a product by its ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update a product by its ID
    public Product updateProduct(Long id, Product updatedProduct, Long categoryId) {
        Product product = getProductById(id);

        // Update product details
        product.setName(updatedProduct.getName());

        // Update category association if provided
        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    // Delete a product by its ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
