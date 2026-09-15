package com.example.product2.Service;


import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.entity.Product;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public  interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product addProduct(ProductRequest request);
}
