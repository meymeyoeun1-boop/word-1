package com.example.product2.Service;


import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.dto.Response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface ProductService {

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse addProduct(ProductRequest request);
    void deleteProduct(Long id);
}
