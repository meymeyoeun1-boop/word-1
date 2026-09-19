package com.example.product2.controller;

import com.example.product2.Service.ProductService;
import com.example.product2.Service.ProductServiceImpl;
import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.dto.Response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/list")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id ){return productService.getProductById(id);}

    @PostMapping("/create")
    public ProductResponse addProduct(@RequestBody ProductRequest request) {
       return productService.addProduct(request);
    }

}
