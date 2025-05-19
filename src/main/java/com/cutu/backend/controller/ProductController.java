package com.cutu.backend.controller;

import com.cutu.backend.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/v1")
public class ProductController {
    private List<Product> products = new ArrayList<>();

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return this.products;
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return products.stream().filter(product -> product.getId()==id)
                .findFirst().get();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product) {
        products.add(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        Product productToDelete = getProduct(id);
        products.remove(productToDelete);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        Product productToUpdate = getProduct(product.getId());

        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());
    }

 }
