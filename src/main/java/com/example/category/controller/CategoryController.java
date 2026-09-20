package com.example.category.controller;

import com.example.category.Service.CategoryService;
import com.example.category.Service.CategoryServiceImpl;
import com.example.category.dto.Request.CategoryRequest;
import com.example.category.dto.Response.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorys")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService ,CategoryServiceImpl categoryServiceInmpl) {
        this.categoryService = categoryService;
    }

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
