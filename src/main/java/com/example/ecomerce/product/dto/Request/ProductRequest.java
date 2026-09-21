package com.example.ecomerce.product.dto.Request;

import lombok.Builder;

@Builder

public record ProductRequest(String name, Double price,String description) {

}



