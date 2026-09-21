package com.example.ecomerce.category.Service;

import com.example.ecomerce.category.Repository.CategoryRespository;
import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import com.example.ecomerce.category.entity.Category;
import com.example.ecomerce.category.mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRespository categoryRepository;
    private final CategoryMapper categoryMapper;



    @Transactional()
    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse) // Map each entity to DTO
                .toList();
    }

    @Override
    @Transactional()
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return categoryMapper.toResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse addCategory(CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        Category savedCategory = categoryRepository.save( category);
        return  categoryMapper.toResponse(savedCategory);
    }
}
