package com.example.product2.mapper;

import com.example.product2.dto.Request.ProductRequest;
import com.example.product2.dto.Response.ProductResponse;
import com.example.product2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id",source = "id")
    ProductResponse toResponse(Product product);

    Product toEntity (ProductRequest request);

}
