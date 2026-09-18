package com.example.product2.controller;

import com.example.product2.Service.ProductService;
import com.example.product2.Service.ProductServiceImpl;
import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id ){return productService.getProductById(id);}

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody ProductRequest request) {
        Product createProduct = productService.addProduct(request);
        return  createProduct;
    }
}
