package com.example.ecomerce.category.mapper;

import com.example.ecomerce.category.dto.Request.CategoryRequest;
import com.example.ecomerce.category.dto.Response.CategoryResponse;
import com.example.ecomerce.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id",source = "id")
    CategoryResponse toResponse(Category category);

    Category toEntity (CategoryRequest request);
}
