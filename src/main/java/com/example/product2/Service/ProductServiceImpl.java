package com.example.product2.Service;

import com.example.product2.Repository.ProductRepository;
import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.dto.Response.ProductResponse;
import com.example.product2.entity.Product;
import com.example.product2.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper; // Inject the mapper!

    @Override
    @Transactional()
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse) // Map each entity to DTO
                .toList();
    }

    @Override
    @Transactional()
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return productMapper.toResponse(product);
    }

    @Transactional
    public ProductResponse addProduct(ProductRequest request) {
        Product newProduct = productMapper.toEntity(request); // DTO -> Entity
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toResponse(savedProduct); // Entity -> DTO
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }



}
