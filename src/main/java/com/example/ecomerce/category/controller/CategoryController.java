package com.example.ecomerce.category.controller;

import com.example.ecomerce.category.Service.CategoryService;
import com.example.ecomerce.category.Service.CategoryServiceImpl;
import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/list")
    public List<CategoryResponse> getAllCategory() {
        return categoryService.getAllCategory();
    }
    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id )
    {return categoryService.getCategoryById(id);}

    @PostMapping("/create")
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        return categoryService.addCategory(request);
    }


}
