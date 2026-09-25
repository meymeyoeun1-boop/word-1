package com.example.ecomerce.product.Service;

import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Request.ProductRequestUpdate;
import com.example.ecomerce.product.dto.Response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse addProduct(ProductRequest request);

    void deleteProduct(Long id);

    ProductResponse updateProduct(Long id, ProductRequestUpdate requestUpdate);
}