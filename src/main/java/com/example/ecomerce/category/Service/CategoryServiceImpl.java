package com.example.ecomerce.category.Service;

import com.example.ecomerce.category.Repository.CategoryRespository;
import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Request.CategoryRequestUpdate;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import com.example.ecomerce.category.entity.Category;
import com.example.ecomerce.category.mapper.CategoryMapper;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    @Transactional
    public CategoryResponse deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category with id " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
        return null;
    }


    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequestUpdate requestUpdate) {
        Category oldData = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        oldData.setName(requestUpdate.getName());
        oldData.setDescription(requestUpdate.getDescription());

        Category savedCategory = categoryRepository.save(oldData);
        return categoryMapper.toResponse(savedCategory);
    }



}
