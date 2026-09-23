package com.example.ecomerce.product.mapper;

import com.example.ecomerce.product.dto.Request.ProductRequest;
import com.example.ecomerce.product.dto.Response.ProductResponse;
import com.example.ecomerce.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id",source = "id")

    ProductResponse toResponse(Product product);

    @Mapping(target = "qty",source = "stock")
    Product toEntity (ProductRequest request);

}
