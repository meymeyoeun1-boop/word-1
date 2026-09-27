package com.example.ecomerce.category.controller;

import com.example.ecomerce.category.Service.CategoryService;
import com.example.ecomerce.category.Service.CategoryServiceImpl;
import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Request.CategoryRequestUpdate;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import com.example.ecomerce.category.entity.Category;
import com.example.ecomerce.product.common.HttpBodyResponse;
import com.example.ecomerce.product.dto.Request.ProductRequestUpdate;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequestUpdate;
import com.example.ecomerce.suppliers.dto.Response.SupplierResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public CategoryResponse deleteCategory(@PathVariable  Long id){
        return categoryService.deleteCategory(id);
    }
    @PutMapping("/{id}")
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestUpdate requestUpdate) {

        return categoryService.updateCategory(id, requestUpdate);
    }




}
