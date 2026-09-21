package com.example.ecomerce.product.Service;


import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface ProductService {

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse addProduct(ProductRequest request);

    void deleteProduct(Long id);
}
