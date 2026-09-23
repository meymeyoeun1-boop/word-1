package com.example.ecomerce.product.controller;

import com.example.ecomerce.product.Service.ProductService;
import com.example.ecomerce.product.Service.ProductServiceImpl;
import com.example.ecomerce.product.common.BaseRestController;
import com.example.ecomerce.product.common.HttpBodyResponse;
import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")

public class ProductController extends BaseRestController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/list")
    public ResponseEntity<HttpBodyResponse<java.util.List<ProductResponse>>> getAllProducts() {
        return responseSucceed(ProductService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity <HttpBodyResponse<ProductResponse>> getProductById(@PathVariable Long id ){
        return responseSucceed (productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<HttpBodyResponse<ProductResponse>> addProduct(@Valid @RequestBody ProductRequest request) {
       return responseCreated (productService.addProduct(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpBodyResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return responseDeleted();
    }

}
