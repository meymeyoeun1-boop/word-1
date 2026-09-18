package com.example.product2.Service;

import com.example.product2.Repository.ProductRepository;
import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional()
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional()
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Transactional
    public Product addProduct(ProductRequest request) {
        Product newProduct = Product.builder()
                .name(request.name())
                .price(request.price())
                .description(request.description())
                .build();

        return productRepository.save(newProduct);
    }


}
