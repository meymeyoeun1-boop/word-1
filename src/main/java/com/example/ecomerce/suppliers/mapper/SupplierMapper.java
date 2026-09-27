package com.example.ecomerce.suppliers.mapper;


import com.example.ecomerce.suppliers.dto.Request.SupplierRequest;
import com.example.ecomerce.suppliers.dto.Response.SupplierResponse;
import com.example.ecomerce.suppliers.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "id",source = "id")
     SupplierResponse toResponse(Supplier supplier);

    @Mapping(target = "contact_person",source = "contact_person")
    Supplier toEntity (SupplierRequest request);
}

