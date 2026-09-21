package com.example.ecomerce.category.Service;

import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryResponse> getAllCategory();

    CategoryResponse getCategoryById(Long id);

    CategoryResponse addCategory(CategoryRequest request);

}
