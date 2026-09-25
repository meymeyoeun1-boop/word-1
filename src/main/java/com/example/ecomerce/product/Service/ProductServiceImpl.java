package com.example.ecomerce.product.Service;

import com.example.ecomerce.product.Repository.ProductRepository;
import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Request.ProductRequestUpdate;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import com.example.ecomerce.product.entity.Product;
import com.example.ecomerce.product.exception.ProductNotFoundException;
import com.example.ecomerce.product.mapper.ProductMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse addProduct(ProductRequest request) {
        Product newProduct = productMapper.toEntity(request);
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequestUpdate requestUpdate) {
        Product oldData = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        oldData.setName(requestUpdate.getName());
        oldData.setPrice(requestUpdate.getPrice());
        oldData.setDescription(requestUpdate.getDescription());
        oldData.setStock(requestUpdate.getStock());

        Product savedProduct = productRepository.save(oldData);
        return productMapper.toResponse(savedProduct); // ប្រាកដថាប្រើ method name ត្រូវក្នុង Mapper
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}