package com.example.ecomerce.product.controller;

import com.example.ecomerce.product.Service.ProductService;
import com.example.ecomerce.product.common.BaseRestController;
import com.example.ecomerce.product.common.HttpBodyResponse;
import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Request.ProductRequestUpdate;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends BaseRestController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<HttpBodyResponse<List<ProductResponse>>> getAllProducts() {
        return responseSucceed(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpBodyResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        return responseSucceed(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<HttpBodyResponse<ProductResponse>> addProduct(@Valid @RequestBody ProductRequest request) {
        return responseCreated(productService.addProduct(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpBodyResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return responseDeleted();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpBodyResponse<ProductResponse>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestUpdate requestUpdate) {
        ProductResponse updatedProduct = productService.updateProduct(id, requestUpdate);
        return responseSucceed(updatedProduct);
    }
}