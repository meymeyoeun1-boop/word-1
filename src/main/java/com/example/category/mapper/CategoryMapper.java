package com.example.category.mapper;

import com.example.category.dto.Request.CategoryRequest;
import com.example.category.dto.Response.CategoryResponse;
import com.example.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id",source = "id")
    CategoryResponse toResponse(Category category);

    Category toEntity (CategoryRequest request);
}
